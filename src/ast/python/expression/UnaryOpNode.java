package ast.python.expression;

import ast.python.PythonAstVisitor;

public class UnaryOpNode extends ExpressionNode {

    public final String op;
    public final ExpressionNode operand;

    public UnaryOpNode(int line, String op, ExpressionNode operand) {
        super(line);
        this.op = op;
        this.operand = operand;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "UnaryOp(" + op + ") [line " + line + "]");
        operand.print(indent + 1);
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
