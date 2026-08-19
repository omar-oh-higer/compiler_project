package ast.template.css;

import ast.template.TemplateAstNode;
import ast.template.TemplateAstVisitor;

import java.util.List;

/** Used both for an inline <style> block and for a standalone external .css file. */
public class StyleBlockNode extends TemplateAstNode {

    public final List<CssRuleNode> rules;

    public StyleBlockNode(int line, List<CssRuleNode> rules) {
        super(line);
        this.rules = rules;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "StyleBlock(" + rules.size() + " rule(s)) [line " + line + "]");
        printChildren(rules, indent + 1);
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
