package ast.python.expression;

import ast.python.PythonAstVisitor;

public class NoneLiteralNode extends ExpressionNode {

    public NoneLiteralNode(int line) {
        super(line);
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "None [line " + line + "]");
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
