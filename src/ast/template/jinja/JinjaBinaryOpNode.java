package ast.template.jinja;

import ast.template.TemplateAstVisitor;

public class JinjaBinaryOpNode extends JinjaExprNode {

    public final JinjaExprNode left;
    public final String op;
    public final JinjaExprNode right;

    public JinjaBinaryOpNode(int line, JinjaExprNode left, String op, JinjaExprNode right) {
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
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
