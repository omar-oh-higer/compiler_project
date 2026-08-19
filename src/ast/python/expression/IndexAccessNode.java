package ast.python.expression;

import ast.python.PythonAstVisitor;

public class IndexAccessNode extends ExpressionNode {

    public final ExpressionNode base;
    public final ExpressionNode index;

    public IndexAccessNode(int line, ExpressionNode base, ExpressionNode index) {
        super(line);
        this.base = base;
        this.index = index;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "IndexAccess [line " + line + "]");
        base.print(indent + 1);
        index.print(indent + 1);
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
