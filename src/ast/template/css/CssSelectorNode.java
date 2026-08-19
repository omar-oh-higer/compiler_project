package ast.template.css;

import ast.template.TemplateAstNode;
import ast.template.TemplateAstVisitor;

public class CssSelectorNode extends TemplateAstNode {

    public final String tagName;
    public final String className;
    public final String pseudoClass;

    public CssSelectorNode(int line, String tagName, String className, String pseudoClass) {
        super(line);
        this.tagName = tagName;
        this.className = className;
        this.pseudoClass = pseudoClass;
    }

    @Override
    public void print(int indent) {
        StringBuilder desc = new StringBuilder();
        if (tagName != null) desc.append(tagName);
        if (className != null) desc.append('.').append(className);
        if (pseudoClass != null) desc.append(':').append(pseudoClass);
        System.out.println(pad(indent) + "Selector(" + desc + ") [line " + line + "]");
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
