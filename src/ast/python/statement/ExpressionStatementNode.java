package ast.python.statement;

import ast.python.PythonAstVisitor;
import ast.python.expression.ExpressionNode;

public class ExpressionStatementNode extends StatementNode {

    public final ExpressionNode expression;

    public ExpressionStatementNode(int line, ExpressionNode expression) {
        super(line);
        this.expression = expression;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "ExpressionStmt [line " + line + "]");
        expression.print(indent + 1);
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
