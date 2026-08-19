package ast.python;

import ast.python.expression.*;
import ast.python.statement.*;

/** Default no-op implementation so callers only override what they need. */
public abstract class PythonAstBaseVisitor<R> implements PythonAstVisitor<R> {

    @Override
    public R visit(ProgramNode node) { return null; }

    @Override
    public R visit(ImportNode node) { return null; }

    @Override
    public R visit(AppInitNode node) { return null; }

    @Override
    public R visit(RouteDeclNode node) { return null; }

    @Override
    public R visit(FunctionDeclNode node) { return null; }

    @Override
    public R visit(AssignmentNode node) { return null; }

    @Override
    public R visit(IfNode node) { return null; }

    @Override
    public R visit(WhileNode node) { return null; }

    @Override
    public R visit(ForNode node) { return null; }

    @Override
    public R visit(WithOpenNode node) { return null; }

    @Override
    public R visit(ReturnNode node) { return null; }

    @Override
    public R visit(BreakNode node) { return null; }

    @Override
    public R visit(ExpressionStatementNode node) { return null; }

    @Override
    public R visit(NameNode node) { return null; }

    @Override
    public R visit(NumberNode node) { return null; }

    @Override
    public R visit(StringNode node) { return null; }

    @Override
    public R visit(BoolLiteralNode node) { return null; }

    @Override
    public R visit(NoneLiteralNode node) { return null; }

    @Override
    public R visit(ListLiteralNode node) { return null; }

    @Override
    public R visit(DictLiteralNode node) { return null; }

    @Override
    public R visit(BinaryOpNode node) { return null; }

    @Override
    public R visit(UnaryOpNode node) { return null; }

    @Override
    public R visit(IndexAccessNode node) { return null; }

    @Override
    public R visit(AttributeAccessNode node) { return null; }

    @Override
    public R visit(CallNode node) { return null; }
}
