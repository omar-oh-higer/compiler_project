package ast.template.html;

import ast.template.TemplateAstNode;
import ast.template.TemplateAstVisitor;

import java.util.List;

public class HtmlElementNode extends TemplateAstNode {

    public final String tagName;
    public final List<AttributeNode> attributes;
    public final List<TemplateAstNode> children;
    public final int closingLine;

    public HtmlElementNode(int line, String tagName, List<AttributeNode> attributes,
                            List<TemplateAstNode> children, int closingLine) {
        super(line);
        this.tagName = tagName;
        this.attributes = attributes;
        this.children = children;
        this.closingLine = closingLine;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Element(<" + tagName + ">) [line " + line + "-" + closingLine + "]");
        printChildren(attributes, indent + 1);
        printChildren(children, indent + 1);
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
