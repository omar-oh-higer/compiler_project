package ast.template.html;

import ast.template.TemplateAstNode;
import ast.template.TemplateAstVisitor;

public class AttributeNode extends TemplateAstNode {

    public final String name;
    public final AttributeValueNode value;

    public AttributeNode(int line, String name, AttributeValueNode value) {
        super(line);
        this.name = name;
        this.value = value;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Attribute(" + name + ") [line " + line + "]");
        if (value != null) {
            value.print(indent + 1);
        }
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
