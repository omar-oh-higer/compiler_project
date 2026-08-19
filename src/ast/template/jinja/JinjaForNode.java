package ast.template.jinja;

import ast.template.TemplateAstNode;
import ast.template.TemplateAstVisitor;

import java.util.List;

public class JinjaForNode extends TemplateAstNode {

    public final String loopVar;
    public final JinjaExprNode iterable;
    public final List<TemplateAstNode> body;
    public final List<TemplateAstNode> elseBody;

    public JinjaForNode(int line, String loopVar, JinjaExprNode iterable,
                         List<TemplateAstNode> body, List<TemplateAstNode> elseBody) {
        super(line);
        this.loopVar = loopVar;
        this.iterable = iterable;
        this.body = body;
        this.elseBody = elseBody;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "JinjaFor(" + loopVar + " in ..."
                + (elseBody != null ? ", has else" : "") + ") [line " + line + "]");
        iterable.print(indent + 1);
        printChildren(body, indent + 1);
        if (elseBody != null) {
            System.out.println(pad(indent + 1) + "Else:");
            for (TemplateAstNode node : elseBody) {
                node.print(indent + 2);
            }
        }
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
