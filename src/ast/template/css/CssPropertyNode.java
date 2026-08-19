package ast.template.css;

import ast.template.TemplateAstNode;
import ast.template.TemplateAstVisitor;

import java.util.List;

public class CssPropertyNode extends TemplateAstNode {

    public final String name;
    public final List<String> valueParts;

    public CssPropertyNode(int line, String name, List<String> valueParts) {
        super(line);
        this.name = name;
        this.valueParts = valueParts;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Property(" + name + ": " + String.join(" ", valueParts) + ") [line " + line + "]");
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
