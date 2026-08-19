package ast.python.statement;

import ast.python.PythonAstVisitor;
import ast.python.expression.ExpressionNode;

import java.util.List;

public class WithOpenNode extends StatementNode {

    public final ExpressionNode pathExpr;
    public final ExpressionNode modeExpr;
    public final String asName;
    public final List<StatementNode> body;

    public WithOpenNode(int line, ExpressionNode pathExpr, ExpressionNode modeExpr, String asName, List<StatementNode> body) {
        super(line);
        this.pathExpr = pathExpr;
        this.modeExpr = modeExpr;
        this.asName = asName;
        this.body = body;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "WithOpen(as " + asName + ") [line " + line + "]");
        pathExpr.print(indent + 1);
        if (modeExpr != null) {
            modeExpr.print(indent + 1);
        }
        printChildren(body, indent + 1);
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
