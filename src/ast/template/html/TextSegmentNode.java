package ast.template.html;

import ast.template.TemplateAstNode;
import ast.template.TemplateAstVisitor;

public class TextSegmentNode extends TemplateAstNode {

    public final String text;

    public TextSegmentNode(int line, String text) {
        super(line);
        this.text = text;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Text(\"" + text + "\") [line " + line + "]");
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
