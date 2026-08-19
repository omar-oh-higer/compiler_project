package visitor;

import ast.python.PythonAstNode;
import ast.python.ProgramNode;
import ast.python.expression.*;
import ast.python.statement.*;
import gen.PyParser;
import gen.PyParserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Walks the ANTLR parse tree produced by PyParser and builds the clean
 * Python AST (ast.python.*). Precedence-climbing wrapper rules (orExpr,
 * andExpr, additiveExpr...) are collapsed here into plain BinaryOpNode /
 * UnaryOpNode chains instead of being preserved level by level.
 */
public class PythonAstBuilder extends PyParserBaseVisitor<PythonAstNode> {

    @Override
    public ProgramNode visitProgram(PyParser.ProgramContext ctx) {
        List<StatementNode> statements = new ArrayList<>();
        for (PyParser.StatementContext stmtCtx : ctx.statement()) {
            statements.add((StatementNode) visit(stmtCtx));
        }
        return new ProgramNode(ctx.getStart().getLine(), statements);
    }

    // ---------------- statement label wrappers (pure delegation) ----------------

    @Override
    public PythonAstNode visitImportDecl(PyParser.ImportDeclContext ctx) {
        return visit(ctx.importStatement());
    }

    @Override
    public PythonAstNode visitAppInitDecl(PyParser.AppInitDeclContext ctx) {
        return visit(ctx.appInit());
    }

    @Override
    public PythonAstNode visitRouteDecl(PyParser.RouteDeclContext ctx) {
        return visit(ctx.routeDeclaration());
    }

    @Override
    public PythonAstNode visitFunctionDecl(PyParser.FunctionDeclContext ctx) {
        return visit(ctx.functionDeclaration());
    }

    @Override
    public PythonAstNode visitGlobalAssignDecl(PyParser.GlobalAssignDeclContext ctx) {
        return visit(ctx.globalAssignment());
    }

    @Override
    public PythonAstNode visitGlobalIfDecl(PyParser.GlobalIfDeclContext ctx) {
        return visit(ctx.ifStatement());
    }

    @Override
    public PythonAstNode visitReturnStmt(PyParser.ReturnStmtContext ctx) {
        return visit(ctx.returnStatement());
    }

    @Override
    public PythonAstNode visitIfStmt(PyParser.IfStmtContext ctx) {
        return visit(ctx.ifStatement());
    }

    @Override
    public PythonAstNode visitWhileStmt(PyParser.WhileStmtContext ctx) {
        return visit(ctx.whileStatement());
    }

    @Override
    public PythonAstNode visitForStmt(PyParser.ForStmtContext ctx) {
        return visit(ctx.forStatement());
    }

    @Override
    public PythonAstNode visitWithOpenStmt(PyParser.WithOpenStmtContext ctx) {
        return visit(ctx.withOpenStatement());
    }

    @Override
    public PythonAstNode visitAssignStmt(PyParser.AssignStmtContext ctx) {
        return visit(ctx.assignmentStatement());
    }

    @Override
    public PythonAstNode visitExprStmt(PyParser.ExprStmtContext ctx) {
        return visit(ctx.expressionStatement());
    }

    @Override
    public BreakNode visitBreakStmt(PyParser.BreakStmtContext ctx) {
        return new BreakNode(ctx.getStart().getLine());
    }

    // ---------------- real statement builders ----------------

    @Override
    public ImportNode visitFromImport(PyParser.FromImportContext ctx) {
        List<TerminalNode> idents = ctx.IDENT();
        String moduleName = idents.get(0).getText();
        List<String> importedNames = new ArrayList<>();
        for (int i = 1; i < idents.size(); i++) {
            importedNames.add(idents.get(i).getText());
        }
        return new ImportNode(ctx.getStart().getLine(), true, moduleName, importedNames);
    }

    @Override
    public ImportNode visitPlainImport(PyParser.PlainImportContext ctx) {
        return new ImportNode(ctx.getStart().getLine(), false, ctx.IDENT().getText(), new ArrayList<>());
    }

    @Override
    public AppInitNode visitAppInit(PyParser.AppInitContext ctx) {
        List<TerminalNode> idents = ctx.IDENT();
        String varName = idents.get(0).getText();
        String className = idents.get(1).getText();
        List<ExpressionNode> args = new ArrayList<>();
        if (ctx.callArguments() != null) {
            for (CallNode.Argument arg : buildArguments(ctx.callArguments())) {
                args.add(arg.value);
            }
        }
        return new AppInitNode(ctx.getStart().getLine(), varName, className, args);
    }

    @Override
    public RouteDeclNode visitRouteDeclaration(PyParser.RouteDeclarationContext ctx) {
        List<RouteDeclNode.RouteInfo> decorators = new ArrayList<>();
        for (PyParser.RouteDecoratorContext decCtx : ctx.routeDecorator()) {
            decorators.add(buildRouteInfo(decCtx));
        }
        FunctionDeclNode function = visitFunctionDeclaration(ctx.functionDeclaration());
        return new RouteDeclNode(ctx.getStart().getLine(), decorators, function);
    }

    private RouteDeclNode.RouteInfo buildRouteInfo(PyParser.RouteDecoratorContext ctx) {
        String path = stripQuotes(ctx.STRING().getText());
        List<String> methods = List.of("GET");
        for (PyParser.CallArgumentContext argCtx : ctx.callArgument()) {
            CallNode.Argument arg = buildArgument(argCtx);
            if ("methods".equals(arg.name) && arg.value instanceof ListLiteralNode listNode) {
                List<String> extracted = new ArrayList<>();
                for (ExpressionNode item : listNode.items) {
                    if (item instanceof StringNode strNode) {
                        extracted.add(strNode.value);
                    }
                }
                methods = extracted;
            }
        }
        return new RouteDeclNode.RouteInfo(path, methods);
    }

    @Override
    public FunctionDeclNode visitFunctionDeclaration(PyParser.FunctionDeclarationContext ctx) {
        String name = ctx.IDENT().getText();
        List<String> params = new ArrayList<>();
        if (ctx.paramList() != null) {
            for (TerminalNode id : ctx.paramList().IDENT()) {
                params.add(id.getText());
            }
        }
        List<StatementNode> body = buildStatements(ctx.functionBody().stmtInFunction());
        return new FunctionDeclNode(ctx.getStart().getLine(), name, params, body);
    }

    @Override
    public ReturnNode visitReturnStatement(PyParser.ReturnStatementContext ctx) {
        ExpressionNode value = ctx.expression() != null ? (ExpressionNode) visit(ctx.expression()) : null;
        return new ReturnNode(ctx.getStart().getLine(), value);
    }

    @Override
    public IfNode visitIfStatement(PyParser.IfStatementContext ctx) {
        List<PyParser.ExpressionContext> conditions = ctx.expression();
        List<PyParser.BlockContext> blocks = ctx.block();
        List<IfNode.Branch> branches = new ArrayList<>();
        for (int i = 0; i < conditions.size(); i++) {
            ExpressionNode cond = (ExpressionNode) visit(conditions.get(i));
            List<StatementNode> body = buildStatements(blocks.get(i).stmtInFunction());
            branches.add(new IfNode.Branch(cond, body));
        }
        List<StatementNode> elseBody = null;
        if (ctx.ELSE() != null) {
            elseBody = buildStatements(blocks.get(blocks.size() - 1).stmtInFunction());
        }
        return new IfNode(ctx.getStart().getLine(), branches, elseBody);
    }

    @Override
    public WhileNode visitWhileStatement(PyParser.WhileStatementContext ctx) {
        ExpressionNode cond = (ExpressionNode) visit(ctx.expression());
        List<StatementNode> body = buildStatements(ctx.block().stmtInFunction());
        return new WhileNode(ctx.getStart().getLine(), cond, body);
    }

    @Override
    public ForNode visitForStatement(PyParser.ForStatementContext ctx) {
        String loopVar = ctx.IDENT().getText();
        ExpressionNode iterable = (ExpressionNode) visit(ctx.expression());
        List<StatementNode> body = buildStatements(ctx.block().stmtInFunction());
        return new ForNode(ctx.getStart().getLine(), loopVar, iterable, body);
    }

    @Override
    public WithOpenNode visitWithOpenStatement(PyParser.WithOpenStatementContext ctx) {
        List<PyParser.ExpressionContext> exprs = ctx.expression();
        ExpressionNode pathExpr = (ExpressionNode) visit(exprs.get(0));
        ExpressionNode modeExpr = exprs.size() > 1 ? (ExpressionNode) visit(exprs.get(1)) : null;
        String asName = ctx.IDENT().getText();
        List<StatementNode> body = buildStatements(ctx.block().stmtInFunction());
        return new WithOpenNode(ctx.getStart().getLine(), pathExpr, modeExpr, asName, body);
    }

    @Override
    public AssignmentNode visitAssignmentStatement(PyParser.AssignmentStatementContext ctx) {
        ExpressionNode target = (ExpressionNode) visit(ctx.postfixExpr());
        String op = ctx.assignOp().getText();
        ExpressionNode value = (ExpressionNode) visit(ctx.expression());
        return new AssignmentNode(ctx.getStart().getLine(), target, op, value);
    }

    @Override
    public ExpressionStatementNode visitExpressionStatement(PyParser.ExpressionStatementContext ctx) {
        ExpressionNode expr = (ExpressionNode) visit(ctx.expression());
        return new ExpressionStatementNode(ctx.getStart().getLine(), expr);
    }

    @Override
    public AssignmentNode visitGlobalAssignment(PyParser.GlobalAssignmentContext ctx) {
        NameNode target = new NameNode(ctx.getStart().getLine(), ctx.IDENT().getText());
        ExpressionNode value = (ExpressionNode) visit(ctx.expression());
        return new AssignmentNode(ctx.getStart().getLine(), target, "=", value);
    }

    private List<StatementNode> buildStatements(List<PyParser.StmtInFunctionContext> stmts) {
        List<StatementNode> result = new ArrayList<>();
        for (PyParser.StmtInFunctionContext stmtCtx : stmts) {
            result.add((StatementNode) visit(stmtCtx));
        }
        return result;
    }

    // ---------------- expressions: precedence chain collapsed to BinaryOpNode/UnaryOpNode ----------------

    @Override
    public PythonAstNode visitExpression(PyParser.ExpressionContext ctx) {
        return visit(ctx.orExpr());
    }

    @Override
    public ExpressionNode visitOrExpr(PyParser.OrExprContext ctx) {
        List<PyParser.AndExprContext> operands = ctx.andExpr();
        ExpressionNode result = (ExpressionNode) visit(operands.get(0));
        for (int i = 1; i < operands.size(); i++) {
            result = new BinaryOpNode(ctx.getStart().getLine(), result, "or", (ExpressionNode) visit(operands.get(i)));
        }
        return result;
    }

    @Override
    public ExpressionNode visitAndExpr(PyParser.AndExprContext ctx) {
        List<PyParser.NotExprContext> operands = ctx.notExpr();
        ExpressionNode result = (ExpressionNode) visit(operands.get(0));
        for (int i = 1; i < operands.size(); i++) {
            result = new BinaryOpNode(ctx.getStart().getLine(), result, "and", (ExpressionNode) visit(operands.get(i)));
        }
        return result;
    }

    @Override
    public ExpressionNode visitNotExpr(PyParser.NotExprContext ctx) {
        if (ctx.NOT() != null) {
            return new UnaryOpNode(ctx.getStart().getLine(), "not", (ExpressionNode) visit(ctx.notExpr()));
        }
        return (ExpressionNode) visit(ctx.comparisonExpr());
    }

    @Override
    public ExpressionNode visitComparisonExpr(PyParser.ComparisonExprContext ctx) {
        List<PyParser.AdditiveExprContext> operands = ctx.additiveExpr();
        ExpressionNode result = (ExpressionNode) visit(operands.get(0));
        List<PyParser.CompOpContext> ops = ctx.compOp();
        for (int i = 0; i < ops.size(); i++) {
            ExpressionNode right = (ExpressionNode) visit(operands.get(i + 1));
            result = new BinaryOpNode(ctx.getStart().getLine(), result, compOpText(ops.get(i)), right);
        }
        return result;
    }

    private String compOpText(PyParser.CompOpContext ctx) {
        if (ctx.IS() != null && ctx.NOT() != null) return "is not";
        if (ctx.IS() != null) return "is";
        if (ctx.NOT() != null && ctx.IN() != null) return "not in";
        if (ctx.IN() != null) return "in";
        return ctx.getText();
    }

    @Override
    public ExpressionNode visitAdditiveExpr(PyParser.AdditiveExprContext ctx) {
        List<PyParser.MultiplicativeExprContext> operands = ctx.multiplicativeExpr();
        ExpressionNode result = (ExpressionNode) visit(operands.get(0));
        int operandIndex = 1;
        for (int i = 1; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof TerminalNode) {
                String op = child.getText();
                ExpressionNode right = (ExpressionNode) visit(operands.get(operandIndex++));
                result = new BinaryOpNode(ctx.getStart().getLine(), result, op, right);
            }
        }
        return result;
    }

    @Override
    public ExpressionNode visitMultiplicativeExpr(PyParser.MultiplicativeExprContext ctx) {
        List<PyParser.UnaryExprContext> operands = ctx.unaryExpr();
        ExpressionNode result = (ExpressionNode) visit(operands.get(0));
        int operandIndex = 1;
        for (int i = 1; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof TerminalNode) {
                String op = child.getText();
                ExpressionNode right = (ExpressionNode) visit(operands.get(operandIndex++));
                result = new BinaryOpNode(ctx.getStart().getLine(), result, op, right);
            }
        }
        return result;
    }

    @Override
    public ExpressionNode visitUnaryExpr(PyParser.UnaryExprContext ctx) {
        if (ctx.MINUS() != null) {
            return new UnaryOpNode(ctx.getStart().getLine(), "-", (ExpressionNode) visit(ctx.unaryExpr()));
        }
        return (ExpressionNode) visit(ctx.postfixExpr());
    }

    @Override
    public ExpressionNode visitPostfixExpr(PyParser.PostfixExprContext ctx) {
        ExpressionNode result = (ExpressionNode) visit(ctx.atom());
        for (PyParser.TrailerContext trailerCtx : ctx.trailer()) {
            result = applyTrailer(result, trailerCtx);
        }
        return result;
    }

    private ExpressionNode applyTrailer(ExpressionNode base, PyParser.TrailerContext trailerCtx) {
        int line = trailerCtx.getStart().getLine();
        if (trailerCtx instanceof PyParser.IndexTrailerContext idx) {
            ExpressionNode index = (ExpressionNode) visit(idx.expression());
            return new IndexAccessNode(line, base, index);
        }
        if (trailerCtx instanceof PyParser.AttrTrailerContext attr) {
            return new AttributeAccessNode(line, base, attr.IDENT().getText());
        }
        if (trailerCtx instanceof PyParser.CallTrailerContext call) {
            List<CallNode.Argument> args = call.callArguments() != null
                    ? buildArguments(call.callArguments()) : new ArrayList<>();
            return new CallNode(line, base, args);
        }
        throw new IllegalStateException("Unknown trailer: " + trailerCtx.getClass());
    }

    // ---------------- atoms ----------------

    @Override
    public NameNode visitNameAtom(PyParser.NameAtomContext ctx) {
        return new NameNode(ctx.getStart().getLine(), ctx.IDENT().getText());
    }

    @Override
    public NumberNode visitNumberAtom(PyParser.NumberAtomContext ctx) {
        return new NumberNode(ctx.getStart().getLine(), ctx.NUMBER().getText());
    }

    @Override
    public StringNode visitStringAtom(PyParser.StringAtomContext ctx) {
        return new StringNode(ctx.getStart().getLine(), stripQuotes(ctx.STRING().getText()));
    }

    @Override
    public BoolLiteralNode visitTrueAtom(PyParser.TrueAtomContext ctx) {
        return new BoolLiteralNode(ctx.getStart().getLine(), true);
    }

    @Override
    public BoolLiteralNode visitFalseAtom(PyParser.FalseAtomContext ctx) {
        return new BoolLiteralNode(ctx.getStart().getLine(), false);
    }

    @Override
    public NoneLiteralNode visitNoneAtom(PyParser.NoneAtomContext ctx) {
        return new NoneLiteralNode(ctx.getStart().getLine());
    }

    @Override
    public ListLiteralNode visitListAtom(PyParser.ListAtomContext ctx) {
        List<ExpressionNode> items = new ArrayList<>();
        for (PyParser.ExpressionContext exprCtx : ctx.expression()) {
            items.add((ExpressionNode) visit(exprCtx));
        }
        return new ListLiteralNode(ctx.getStart().getLine(), items);
    }

    @Override
    public DictLiteralNode visitDictAtom(PyParser.DictAtomContext ctx) {
        List<DictLiteralNode.Entry> entries = new ArrayList<>();
        for (PyParser.DictItemContext itemCtx : ctx.dictItem()) {
            ExpressionNode key = (ExpressionNode) visit(itemCtx.expression(0));
            ExpressionNode value = (ExpressionNode) visit(itemCtx.expression(1));
            entries.add(new DictLiteralNode.Entry(key, value));
        }
        return new DictLiteralNode(ctx.getStart().getLine(), entries);
    }

    @Override
    public PythonAstNode visitParenAtom(PyParser.ParenAtomContext ctx) {
        return visit(ctx.expression());
    }

    // ---------------- shared helpers ----------------

    private List<CallNode.Argument> buildArguments(PyParser.CallArgumentsContext ctx) {
        List<CallNode.Argument> args = new ArrayList<>();
        for (PyParser.CallArgumentContext argCtx : ctx.callArgument()) {
            args.add(buildArgument(argCtx));
        }
        return args;
    }

    private CallNode.Argument buildArgument(PyParser.CallArgumentContext ctx) {
        ExpressionNode value = (ExpressionNode) visit(ctx.expression());
        String name = ctx.IDENT() != null ? ctx.IDENT().getText() : null;
        return new CallNode.Argument(name, value);
    }

    private String stripQuotes(String raw) {
        return raw.length() >= 2 ? raw.substring(1, raw.length() - 1) : raw;
    }
}
