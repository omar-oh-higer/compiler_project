package semantic;

import ast.python.PythonAstBaseVisitor;
import ast.python.ProgramNode;
import ast.python.expression.*;
import ast.python.statement.*;
import errors.*;
import errors.TypeConflictException.Kind;
import symtab.Scope;
import symtab.Symbol;

import java.util.*;

/**
 * Walks the Python AST (built in Phase 4) and: (a) builds a Scope tree,
 * (b) infers a coarse type for every expression (bottom-up, via the R type
 * parameter of the Visitor itself), and (c) throws the appropriate semantic
 * error the moment something doesn't add up.
 *
 * Scoping model: only `def` and `for` open a new Scope; `if`/`while` share
 * the enclosing scope (matches real Python for if/while, and matches the
 * reference project's own scoping choice for `for`, which is what makes
 * ScopeViolationException/LoopVariableShadowException meaningful to test).
 */
public class PythonSemanticAnalyzer extends PythonAstBaseVisitor<String> {

    private static final Set<String> DATA_TYPES =
            Set.of("number", "string", "bool", "list", "dict", "none");
    private static final Set<String> NON_ITERABLE_TYPES =
            Set.of("number", "bool", "none");
    private static final Set<String> COMPARISON_OPS =
            Set.of("==", "!=", "<", ">", "<=", ">=", "is", "is not", "in", "not in");

    private final Scope globalScope = new Scope(null, "global");
    private Scope currentScope = globalScope;
    private final Set<String> everDefinedNames = new HashSet<>();
    private final Map<String, Integer> functionArity = new HashMap<>();
    private final Set<String> registeredRoutes = new HashSet<>();

    private String currentFunctionName;
    private final List<String> currentFunctionReturnTypes = new ArrayList<>();
    private final List<Integer> currentFunctionReturnLines = new ArrayList<>();

    // templateName -> one Set<kwarg names> per render_template() call site for that
    // template. Collected as a byproduct of this traversal so CrossTreeLinker
    // doesn't need a second full walk of the Python tree just to find these.
    private final Map<String, List<Set<String>>> renderTemplateCalls = new LinkedHashMap<>();

    public Map<String, List<Set<String>>> getRenderTemplateCalls() {
        return renderTemplateCalls;
    }

    public PythonSemanticAnalyzer() {
        globalScope.define(new Symbol("__name__", "string", 0));
        everDefinedNames.add("__name__");

        // built-in functions our subset's samples rely on
        registerBuiltinFunction("len", 1);
    }

    private void registerBuiltinFunction(String name, int arity) {
        functionArity.put(name, arity);
        globalScope.define(new Symbol(name, "function/" + arity, 0));
        everDefinedNames.add(name);
    }

    public void analyze(ProgramNode program) {
        program.accept(this);
    }

    public Scope getGlobalScope() {
        return globalScope;
    }

    // ---------------- program / declarations ----------------

    @Override
    public String visit(ProgramNode node) {
        preRegisterFunctions(node.statements);
        for (StatementNode stmt : node.statements) {
            stmt.accept(this);
        }
        return null;
    }

    private void preRegisterFunctions(List<StatementNode> statements) {
        for (StatementNode stmt : statements) {
            FunctionDeclNode fn = null;
            if (stmt instanceof FunctionDeclNode direct) {
                fn = direct;
            } else if (stmt instanceof RouteDeclNode route) {
                fn = route.function;
            }
            if (fn != null) {
                functionArity.put(fn.name, fn.params.size());
                globalScope.define(new Symbol(fn.name, "function/" + fn.params.size(), fn.line));
                everDefinedNames.add(fn.name);
            }
        }
    }

    @Override
    public String visit(ImportNode node) {
        if (node.fromImport) {
            for (String name : node.importedNames) {
                globalScope.define(new Symbol(name, "unknown", node.line));
                everDefinedNames.add(name);
            }
        } else {
            globalScope.define(new Symbol(node.moduleName, "unknown", node.line));
            everDefinedNames.add(node.moduleName);
        }
        return null;
    }

    @Override
    public String visit(AppInitNode node) {
        for (ExpressionNode arg : node.args) {
            arg.accept(this);
        }
        globalScope.define(new Symbol(node.varName, "unknown", node.line));
        everDefinedNames.add(node.varName);
        return null;
    }

    @Override
    public String visit(RouteDeclNode node) {
        for (RouteDeclNode.RouteInfo info : node.decorators) {
            String key = info.path + "|" + String.join(",", info.methods);
            if (!registeredRoutes.add(key)) {
                throw new DuplicateRoutePathException(info.path, info.methods, node.line);
            }
        }
        node.function.accept(this);
        return null;
    }

    @Override
    public String visit(FunctionDeclNode node) {
        Scope funcScope = new Scope(globalScope, "function:" + node.name);
        for (String param : node.params) {
            funcScope.define(new Symbol(param, "unknown", node.line));
            everDefinedNames.add(param);
        }

        Scope previousScope = currentScope;
        currentScope = funcScope;
        currentFunctionName = node.name;
        currentFunctionReturnTypes.clear();
        currentFunctionReturnLines.clear();

        for (StatementNode stmt : node.body) {
            stmt.accept(this);
        }

        checkReturnTypeConsistency();
        currentScope = previousScope;
        return "function/" + node.params.size();
    }

    private void checkReturnTypeConsistency() {
        String establishedType = null;
        for (int i = 0; i < currentFunctionReturnTypes.size(); i++) {
            String t = currentFunctionReturnTypes.get(i);
            if (!DATA_TYPES.contains(t)) {
                continue; // "unknown" return values can't be compared meaningfully
            }
            if (establishedType == null) {
                establishedType = t;
            } else if (!establishedType.equals(t)) {
                throw new TypeConflictException(Kind.BAD_RETURN_TYPE,
                        "function '" + currentFunctionName + "' returns both '" + establishedType
                                + "' and '" + t + "'",
                        currentFunctionReturnLines.get(i));
            }
        }
    }

    // ---------------- statements ----------------

    @Override
    public String visit(AssignmentNode node) {
        String valueType = node.value.accept(this);
        if (node.target instanceof NameNode nameNode) {
            Symbol existing = currentScope.resolveLocal(nameNode.name);
            if (existing != null && node.op.equals("=")
                    && DATA_TYPES.contains(existing.type) && DATA_TYPES.contains(valueType)
                    && !existing.type.equals(valueType)) {
                throw new TypeConflictException(Kind.REASSIGNED_TYPE,
                        "'" + nameNode.name + "' was '" + existing.type + "', now assigned '" + valueType + "'",
                        node.line);
            }
            currentScope.define(new Symbol(nameNode.name, valueType, node.line));
            everDefinedNames.add(nameNode.name);
        } else {
            node.target.accept(this);
        }
        return null;
    }

    @Override
    public String visit(IfNode node) {
        for (IfNode.Branch branch : node.branches) {
            branch.condition.accept(this);
            for (StatementNode stmt : branch.body) {
                stmt.accept(this);
            }
        }
        if (node.elseBody != null) {
            for (StatementNode stmt : node.elseBody) {
                stmt.accept(this);
            }
        }
        return null;
    }

    @Override
    public String visit(WhileNode node) {
        node.condition.accept(this);
        for (StatementNode stmt : node.body) {
            stmt.accept(this);
        }
        return null;
    }

    @Override
    public String visit(ForNode node) {
        String iterableType = node.iterable.accept(this);
        if (NON_ITERABLE_TYPES.contains(iterableType)) {
            throw new TypeConflictException(Kind.NOT_ITERABLE,
                    "cannot iterate over '" + iterableType + "' in 'for " + node.loopVar + " in ...'",
                    node.line);
        }

        if (currentScope.resolve(node.loopVar) != null) {
            throw new LoopVariableShadowException(node.loopVar, node.line);
        }

        Scope forScope = new Scope(currentScope, "for:" + node.loopVar + "@" + node.line);
        forScope.define(new Symbol(node.loopVar, "unknown", node.line));
        everDefinedNames.add(node.loopVar);

        Scope previousScope = currentScope;
        currentScope = forScope;
        for (StatementNode stmt : node.body) {
            stmt.accept(this);
        }
        currentScope = previousScope;
        return null;
    }

    @Override
    public String visit(WithOpenNode node) {
        node.pathExpr.accept(this);
        if (node.modeExpr != null) {
            node.modeExpr.accept(this);
        }
        currentScope.define(new Symbol(node.asName, "unknown", node.line));
        everDefinedNames.add(node.asName);
        for (StatementNode stmt : node.body) {
            stmt.accept(this);
        }
        return null;
    }

    @Override
    public String visit(ReturnNode node) {
        String type = node.value != null ? node.value.accept(this) : "none";
        currentFunctionReturnTypes.add(type);
        currentFunctionReturnLines.add(node.line);
        return type;
    }

    @Override
    public String visit(BreakNode node) {
        return null;
    }

    @Override
    public String visit(ExpressionStatementNode node) {
        node.expression.accept(this);
        return null;
    }

    // ---------------- expressions ----------------

    @Override
    public String visit(NameNode node) {
        return resolveOrFail(node.name, node.line).type;
    }

    private Symbol resolveOrFail(String name, int line) {
        Symbol sym = currentScope.resolve(name);
        if (sym != null) {
            return sym;
        }
        if (everDefinedNames.contains(name)) {
            throw new ScopeViolationException(name, line, currentScope.name);
        }
        throw new UnresolvedIdentifierException(name, line);
    }

    @Override
    public String visit(NumberNode node) {
        return "number";
    }

    @Override
    public String visit(StringNode node) {
        return "string";
    }

    @Override
    public String visit(BoolLiteralNode node) {
        return "bool";
    }

    @Override
    public String visit(NoneLiteralNode node) {
        return "none";
    }

    @Override
    public String visit(ListLiteralNode node) {
        for (ExpressionNode item : node.items) {
            item.accept(this);
        }
        return "list";
    }

    @Override
    public String visit(DictLiteralNode node) {
        for (DictLiteralNode.Entry entry : node.entries) {
            entry.key.accept(this);
            entry.value.accept(this);
        }
        return "dict";
    }

    @Override
    public String visit(UnaryOpNode node) {
        node.operand.accept(this);
        return node.op.equals("not") ? "bool" : "number";
    }

    @Override
    public String visit(BinaryOpNode node) {
        String leftType = node.left.accept(this);
        String rightType = node.right.accept(this);
        String op = node.op;

        if (op.equals("and") || op.equals("or") || COMPARISON_OPS.contains(op)) {
            return "bool";
        }

        boolean bothKnown = DATA_TYPES.contains(leftType) && DATA_TYPES.contains(rightType);
        if (op.equals("+")) {
            if (bothKnown && !leftType.equals(rightType)) {
                throw new TypeConflictException(Kind.INVALID_OPERATOR_OPERAND,
                        "cannot apply '+' to '" + leftType + "' and '" + rightType + "'", node.line);
            }
            return leftType.equals("string") ? "string" : "number";
        }

        // - * / are only meaningful for numbers
        if (bothKnown && (!leftType.equals("number") || !rightType.equals("number"))) {
            throw new TypeConflictException(Kind.INVALID_OPERATOR_OPERAND,
                    "cannot apply '" + op + "' to '" + leftType + "' and '" + rightType + "'", node.line);
        }
        return "number";
    }

    @Override
    public String visit(IndexAccessNode node) {
        node.base.accept(this);
        node.index.accept(this);
        return "unknown";
    }

    @Override
    public String visit(AttributeAccessNode node) {
        node.base.accept(this);
        return "unknown";
    }

    @Override
    public String visit(CallNode node) {
        for (CallNode.Argument arg : node.args) {
            arg.value.accept(this);
        }

        if (node.callee instanceof NameNode nameNode) {
            String calleeType = resolveOrFail(nameNode.name, node.line).type;
            if (functionArity.containsKey(nameNode.name)) {
                int expected = functionArity.get(nameNode.name);
                int actual = node.args.size();
                if (expected != actual) {
                    throw new TypeConflictException(Kind.ARG_COUNT_MISMATCH,
                            "'" + nameNode.name + "' expects " + expected + " argument(s) but got " + actual,
                            node.line);
                }
            } else if (DATA_TYPES.contains(calleeType)) {
                throw new TypeConflictException(Kind.NOT_CALLABLE,
                        "'" + nameNode.name + "' is not callable (type '" + calleeType + "')", node.line);
            }

            if (nameNode.name.equals("render_template") && !node.args.isEmpty()
                    && node.args.get(0).value instanceof StringNode templateNameNode) {
                Set<String> kwargNames = new LinkedHashSet<>();
                for (int i = 1; i < node.args.size(); i++) {
                    CallNode.Argument arg = node.args.get(i);
                    if (arg.name != null) {
                        kwargNames.add(arg.name);
                    }
                }
                renderTemplateCalls.computeIfAbsent(templateNameNode.value, k -> new ArrayList<>()).add(kwargNames);
            }
        } else {
            node.callee.accept(this);
        }
        return "unknown";
    }
}
