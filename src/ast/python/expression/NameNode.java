package ast.python.expression;

import ast.python.PythonAstVisitor;

public class NameNode extends ExpressionNode {

    public final String name;

    public NameNode(int line, String name) {
        super(line);
        this.name = name;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Name(" + name + ") [line " + line + "]");
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
