package ast.python.expression;

import ast.python.PythonAstVisitor;

public class BoolLiteralNode extends ExpressionNode {

    public final boolean value;

    public BoolLiteralNode(int line, boolean value) {
        super(line);
        this.value = value;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Bool(" + value + ") [line " + line + "]");
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
