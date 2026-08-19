package ast.template.jinja;

import ast.template.TemplateAstVisitor;

public class JinjaLiteralNode extends JinjaExprNode {

    public final String value;
    public final String kind;

    public JinjaLiteralNode(int line, String value, String kind) {
        super(line);
        this.value = value;
        this.kind = kind;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Literal(" + kind + ":" + value + ") [line " + line + "]");
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
