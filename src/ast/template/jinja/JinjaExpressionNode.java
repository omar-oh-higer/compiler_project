package ast.template.jinja;

import ast.template.TemplateAstNode;
import ast.template.TemplateAstVisitor;

import java.util.List;

/** A {{ expr | filter }} tag. */
public class JinjaExpressionNode extends TemplateAstNode {

    public final JinjaExprNode expr;
    public final List<FilterNode> filters;

    public JinjaExpressionNode(int line, JinjaExprNode expr, List<FilterNode> filters) {
        super(line);
        this.expr = expr;
        this.filters = filters;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "JinjaExpression [line " + line + "]");
        expr.print(indent + 1);
        printChildren(filters, indent + 1);
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
