package ast.python.expression;

import ast.python.PythonAstVisitor;

public class AttributeAccessNode extends ExpressionNode {

    public final ExpressionNode base;
    public final String attrName;

    public AttributeAccessNode(int line, ExpressionNode base, String attrName) {
        super(line);
        this.base = base;
        this.attrName = attrName;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "AttributeAccess(." + attrName + ") [line " + line + "]");
        base.print(indent + 1);
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
