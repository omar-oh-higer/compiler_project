package ast.python.expression;

import ast.python.PythonAstVisitor;

import java.util.List;

public class ListLiteralNode extends ExpressionNode {

    public final List<ExpressionNode> items;

    public ListLiteralNode(int line, List<ExpressionNode> items) {
        super(line);
        this.items = items;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "List(" + items.size() + " items) [line " + line + "]");
        printChildren(items, indent + 1);
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
