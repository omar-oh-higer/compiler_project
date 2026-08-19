package ast.python.statement;

import ast.python.PythonAstVisitor;
import ast.python.expression.ExpressionNode;

import java.util.List;

public class WhileNode extends StatementNode {

    public final ExpressionNode condition;
    public final List<StatementNode> body;

    public WhileNode(int line, ExpressionNode condition, List<StatementNode> body) {
        super(line);
        this.condition = condition;
        this.body = body;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "While [line " + line + "]");
        condition.print(indent + 1);
        printChildren(body, indent + 1);
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
