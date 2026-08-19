package ast.template.css;

import ast.template.TemplateAstNode;
import ast.template.TemplateAstVisitor;

import java.util.List;

public class CssRuleNode extends TemplateAstNode {

    public final CssSelectorNode selector;
    public final List<CssPropertyNode> properties;

    public CssRuleNode(int line, CssSelectorNode selector, List<CssPropertyNode> properties) {
        super(line);
        this.selector = selector;
        this.properties = properties;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Rule [line " + line + "]");
        selector.print(indent + 1);
        printChildren(properties, indent + 1);
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
