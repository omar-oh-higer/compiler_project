package ast.python.statement;

import ast.python.PythonAstVisitor;
import ast.python.expression.ExpressionNode;

import java.util.List;

public class ForNode extends StatementNode {

    public final String loopVar;
    public final ExpressionNode iterable;
    public final List<StatementNode> body;

    public ForNode(int line, String loopVar, ExpressionNode iterable, List<StatementNode> body) {
        super(line);
        this.loopVar = loopVar;
        this.iterable = iterable;
        this.body = body;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "For(" + loopVar + " in ...) [line " + line + "]");
        iterable.print(indent + 1);
        printChildren(body, indent + 1);
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
