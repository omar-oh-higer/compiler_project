package ast.python;

import ast.python.expression.*;
import ast.python.statement.*;

public interface PythonAstVisitor<R> {
    R visit(ProgramNode node);

    R visit(ImportNode node);
    R visit(AppInitNode node);
    R visit(RouteDeclNode node);
    R visit(FunctionDeclNode node);
    R visit(AssignmentNode node);
    R visit(IfNode node);
    R visit(WhileNode node);
    R visit(ForNode node);
    R visit(WithOpenNode node);
    R visit(ReturnNode node);
    R visit(BreakNode node);
    R visit(ExpressionStatementNode node);

    R visit(NameNode node);
    R visit(NumberNode node);
    R visit(StringNode node);
    R visit(BoolLiteralNode node);
    R visit(NoneLiteralNode node);
    R visit(ListLiteralNode node);
    R visit(DictLiteralNode node);
    R visit(BinaryOpNode node);
    R visit(UnaryOpNode node);
    R visit(IndexAccessNode node);
    R visit(AttributeAccessNode node);
    R visit(CallNode node);
}
