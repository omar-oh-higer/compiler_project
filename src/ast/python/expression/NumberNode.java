package ast.python.expression;

import ast.python.PythonAstVisitor;

public class NumberNode extends ExpressionNode {

    public final String value;

    public NumberNode(int line, String value) {
        super(line);
        this.value = value;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Number(" + value + ") [line " + line + "]");
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
