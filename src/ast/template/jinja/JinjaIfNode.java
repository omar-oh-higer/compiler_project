package ast.template.jinja;

import ast.template.TemplateAstNode;
import ast.template.TemplateAstVisitor;

import java.util.List;

public class JinjaIfNode extends TemplateAstNode {

    public static final class Branch {
        public final JinjaExprNode condition;
        public final List<TemplateAstNode> body;

        public Branch(JinjaExprNode condition, List<TemplateAstNode> body) {
            this.condition = condition;
            this.body = body;
        }

        void print(int indent) {
            System.out.println("  ".repeat(indent) + "Branch:");
            condition.print(indent + 1);
            for (TemplateAstNode node : body) {
                node.print(indent + 1);
            }
        }
    }

    public final List<Branch> branches;
    public final List<TemplateAstNode> elseBody;

    public JinjaIfNode(int line, List<Branch> branches, List<TemplateAstNode> elseBody) {
        super(line);
        this.branches = branches;
        this.elseBody = elseBody;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "JinjaIf(" + branches.size() + " branch(es)"
                + (elseBody != null ? ", has else" : "") + ") [line " + line + "]");
        for (Branch branch : branches) {
            branch.print(indent + 1);
        }
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
