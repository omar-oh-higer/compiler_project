package ast.template.html;

import ast.template.TemplateAstNode;
import ast.template.TemplateAstVisitor;

import java.util.List;

/**
 * The value between the quotes of an HTML attribute. Its parts are a mix of
 * plain text segments and Jinja expressions, e.g. value="/products/{{ product.id }}"
 * becomes [TextSegmentNode("/products/"), JinjaExpressionNode(product.id)].
 */
public class AttributeValueNode extends TemplateAstNode {

    public final List<TemplateAstNode> parts;

    public AttributeValueNode(int line, List<TemplateAstNode> parts) {
        super(line);
        this.parts = parts;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "AttributeValue(" + parts.size() + " part(s)) [line " + line + "]");
        printChildren(parts, indent + 1);
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
