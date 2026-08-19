package ast.python.statement;

import ast.python.PythonAstVisitor;
import ast.python.expression.ExpressionNode;

public class ReturnNode extends StatementNode {

    public final ExpressionNode value;

    public ReturnNode(int line, ExpressionNode value) {
        super(line);
        this.value = value;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Return [line " + line + "]");
        if (value != null) {
            value.print(indent + 1);
        }
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
