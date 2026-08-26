package codegen;

import ast.python.PythonAstBaseVisitor;
import ast.python.ProgramNode;
import ast.python.expression.*;
import ast.python.statement.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The reverse of PythonAstBuilder: walks the Python AST and prints real
 * Python source. Statement visit methods write lines to the shared
 * IndentingWriter (side effect, return null); expression visit methods are
 * pure and return the source text for that expression.
 */
public class PythonAppEmitter extends PythonAstBaseVisitor<String> {

    private final IndentingWriter out = new IndentingWriter(4);

    public String emit(ProgramNode program) {
        program.accept(this);
        return out.toString();
    }

    // ---------------- program / declarations ----------------

    @Override
    public String visit(ProgramNode node) {
        StatementNode previous = null;
        for (StatementNode stmt : node.statements) {
            boolean bothImports = previous instanceof ImportNode && stmt instanceof ImportNode;
            if (previous != null && !bothImports) {
                out.blank();
            }
            stmt.accept(this);
            previous = stmt;
        }
        return null;
    }

    @Override
    public String visit(ImportNode node) {
        if (node.fromImport) {
            out.line("from " + node.moduleName + " import " + String.join(", ", node.importedNames));
        } else {
            out.line("import " + node.moduleName);
        }
        return null;
    }

    @Override
    public String visit(AppInitNode node) {
        String args = node.args.stream().map(a -> a.accept(this)).collect(Collectors.joining(", "));
        out.line(node.varName + " = " + node.className + "(" + args + ")");
        return null;
    }

    @Override
    public String visit(RouteDeclNode node) {
        for (RouteDeclNode.RouteInfo info : node.decorators) {
            StringBuilder deco = new StringBuilder("@app.route(\"" + info.path + "\"");
            boolean isDefaultGet = info.methods.size() == 1 && info.methods.get(0).equals("GET");
            if (!isDefaultGet) {
                String methodsList = info.methods.stream()
                        .map(m -> "\"" + m + "\"")
                        .collect(Collectors.joining(", "));
                deco.append(", methods=[").append(methodsList).append("]");
            }
            deco.append(")");
            out.line(deco.toString());
        }
        node.function.accept(this);
        return null;
    }

    @Override
    public String visit(FunctionDeclNode node) {
        out.line("def " + node.name + "(" + String.join(", ", node.params) + "):");
        out.indent();
        emitBody(node.body);
        out.dedent();
        return null;
    }

    private void emitBody(List<StatementNode> body) {
        if (body.isEmpty()) {
            out.line("pass");
        } else {
            for (StatementNode stmt : body) {
                stmt.accept(this);
            }
        }
    }

    // ---------------- statements ----------------

    @Override
    public String visit(AssignmentNode node) {
        out.line(node.target.accept(this) + " " + node.op + " " + node.value.accept(this));
        return null;
    }

    @Override
    public String visit(IfNode node) {
        for (int i = 0; i < node.branches.size(); i++) {
            IfNode.Branch branch = node.branches.get(i);
            String keyword = (i == 0) ? "if" : "elif";
            out.line(keyword + " " + branch.condition.accept(this) + ":");
            out.indent();
            emitBody(branch.body);
            out.dedent();
        }
        if (node.elseBody != null) {
            out.line("else:");
            out.indent();
            emitBody(node.elseBody);
            out.dedent();
        }
        return null;
    }

    @Override
    public String visit(WhileNode node) {
        out.line("while " + node.condition.accept(this) + ":");
        out.indent();
        emitBody(node.body);
        out.dedent();
        return null;
    }

    @Override
    public String visit(ForNode node) {
        out.line("for " + node.loopVar + " in " + node.iterable.accept(this) + ":");
        out.indent();
        emitBody(node.body);
        out.dedent();
        return null;
    }

    @Override
    public String visit(WithOpenNode node) {
        StringBuilder header = new StringBuilder("with open(" + node.pathExpr.accept(this));
        if (node.modeExpr != null) {
            header.append(", ").append(node.modeExpr.accept(this));
        }
        header.append(") as ").append(node.asName).append(":");
        out.line(header.toString());
        out.indent();
        emitBody(node.body);
        out.dedent();
        return null;
    }

    @Override
    public String visit(ReturnNode node) {
        out.line(node.value != null ? ("return " + node.value.accept(this)) : "return");
        return null;
    }

    @Override
    public String visit(BreakNode node) {
        out.line("break");
        return null;
    }

    @Override
    public String visit(ExpressionStatementNode node) {
        out.line(node.expression.accept(this));
        return null;
    }

    // ---------------- expressions (pure — no writes to `out`) ----------------

    @Override
    public String visit(NameNode node) {
        return node.name;
    }

    @Override
    public String visit(NumberNode node) {
        return node.value;
    }

    @Override
    public String visit(StringNode node) {
        return "\"" + escape(node.value) + "\"";
    }

    @Override
    public String visit(BoolLiteralNode node) {
        return node.value ? "True" : "False";
    }

    @Override
    public String visit(NoneLiteralNode node) {
        return "None";
    }

    @Override
    public String visit(ListLiteralNode node) {
        String items = node.items.stream().map(i -> i.accept(this)).collect(Collectors.joining(", "));
        return "[" + items + "]";
    }

    @Override
    public String visit(DictLiteralNode node) {
        String entries = node.entries.stream()
                .map(e -> e.key.accept(this) + ": " + e.value.accept(this))
                .collect(Collectors.joining(", "));
        return "{" + entries + "}";
    }

    @Override
    public String visit(UnaryOpNode node) {
        String operand = wrapIfCompound(node.operand);
        return node.op.equals("not") ? ("not " + operand) : ("-" + operand);
    }

    @Override
    public String visit(BinaryOpNode node) {
        return wrapIfCompound(node.left) + " " + node.op + " " + wrapIfCompound(node.right);
    }

    // always-safe parenthesization: a nested binary/unary operand always
    // gets wrapped, since the AST no longer remembers original precedence.
    private String wrapIfCompound(ExpressionNode node) {
        String text = node.accept(this);
        return (node instanceof BinaryOpNode || node instanceof UnaryOpNode) ? ("(" + text + ")") : text;
    }

    @Override
    public String visit(IndexAccessNode node) {
        return node.base.accept(this) + "[" + node.index.accept(this) + "]";
    }

    @Override
    public String visit(AttributeAccessNode node) {
        return node.base.accept(this) + "." + node.attrName;
    }

    @Override
    public String visit(CallNode node) {
        String args = node.args.stream()
                .map(a -> a.name != null ? (a.name + "=" + a.value.accept(this)) : a.value.accept(this))
                .collect(Collectors.joining(", "));
        return node.callee.accept(this) + "(" + args + ")";
    }

    private String escape(String raw) {
        return raw.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
