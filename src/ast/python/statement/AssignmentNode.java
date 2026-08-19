package ast.python.statement;

import ast.python.PythonAstVisitor;
import ast.python.expression.ExpressionNode;

public class AssignmentNode extends StatementNode {

    public final ExpressionNode target;
    public final String op;
    public final ExpressionNode value;

    public AssignmentNode(int line, ExpressionNode target, String op, ExpressionNode value) {
        super(line);
        this.target = target;
        this.op = op;
        this.value = value;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Assignment(" + op + ") [line " + line + "]");
        target.print(indent + 1);
        value.print(indent + 1);
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
