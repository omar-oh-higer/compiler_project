package ast.python.statement;

import ast.python.PythonAstVisitor;
import ast.python.expression.ExpressionNode;

import java.util.List;

public class IfNode extends StatementNode {

    public static final class Branch {
        public final ExpressionNode condition;
        public final List<StatementNode> body;

        public Branch(ExpressionNode condition, List<StatementNode> body) {
            this.condition = condition;
            this.body = body;
        }

        void print(int indent) {
            System.out.println("  ".repeat(indent) + "Branch:");
            condition.print(indent + 1);
            for (StatementNode stmt : body) {
                stmt.print(indent + 1);
            }
        }
    }

    public final List<Branch> branches;
    public final List<StatementNode> elseBody;

    public IfNode(int line, List<Branch> branches, List<StatementNode> elseBody) {
        super(line);
        this.branches = branches;
        this.elseBody = elseBody;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "If(" + branches.size() + " branch(es)"
                + (elseBody != null ? ", has else" : "") + ") [line " + line + "]");
        for (Branch branch : branches) {
            branch.print(indent + 1);
        }
        if (elseBody != null) {
            System.out.println(pad(indent + 1) + "Else:");
            for (StatementNode stmt : elseBody) {
                stmt.print(indent + 2);
            }
        }
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
