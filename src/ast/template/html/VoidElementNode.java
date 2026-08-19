package ast.template.html;

import ast.template.TemplateAstNode;
import ast.template.TemplateAstVisitor;

import java.util.List;

public class VoidElementNode extends TemplateAstNode {

    public final String tagName;
    public final List<AttributeNode> attributes;

    public VoidElementNode(int line, String tagName, List<AttributeNode> attributes) {
        super(line);
        this.tagName = tagName;
        this.attributes = attributes;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "VoidElement(<" + tagName + "/>) [line " + line + "]");
        printChildren(attributes, indent + 1);
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
