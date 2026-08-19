package ast.template.jinja;

import ast.template.TemplateAstVisitor;

public class JinjaNotNode extends JinjaExprNode {

    public final JinjaExprNode operand;

    public JinjaNotNode(int line, JinjaExprNode operand) {
        super(line);
        this.operand = operand;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Not [line " + line + "]");
        operand.print(indent + 1);
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
