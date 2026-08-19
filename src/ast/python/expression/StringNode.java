package ast.python.expression;

import ast.python.PythonAstVisitor;

public class StringNode extends ExpressionNode {

    public final String value;

    public StringNode(int line, String value) {
        super(line);
        this.value = value;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "String(\"" + value + "\") [line " + line + "]");
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
