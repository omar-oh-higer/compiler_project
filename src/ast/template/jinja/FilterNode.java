package ast.template.jinja;

import ast.template.TemplateAstNode;
import ast.template.TemplateAstVisitor;

import java.util.List;

public class FilterNode extends TemplateAstNode {

    public final String name;
    public final List<JinjaExprNode> args;

    public FilterNode(int line, String name, List<JinjaExprNode> args) {
        super(line);
        this.name = name;
        this.args = args;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Filter(" + name + ") [line " + line + "]");
        printChildren(args, indent + 1);
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
