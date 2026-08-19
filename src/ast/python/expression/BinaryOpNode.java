package ast.python.expression;

import ast.python.PythonAstVisitor;

public class BinaryOpNode extends ExpressionNode {

    public final ExpressionNode left;
    public final String op;
    public final ExpressionNode right;

    public BinaryOpNode(int line, ExpressionNode left, String op, ExpressionNode right) {
        super(line);
        this.left = left;
        this.op = op;
        this.right = right;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "BinaryOp(" + op + ") [line " + line + "]");
        left.print(indent + 1);
        right.print(indent + 1);
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
