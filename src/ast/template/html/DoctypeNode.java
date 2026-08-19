package ast.template.html;

import ast.template.TemplateAstNode;
import ast.template.TemplateAstVisitor;

public class DoctypeNode extends TemplateAstNode {

    public final String rawName;

    public DoctypeNode(int line, String rawName) {
        super(line);
        this.rawName = rawName;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Doctype(" + rawName + ") [line " + line + "]");
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
