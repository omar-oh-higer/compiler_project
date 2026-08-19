package ast.python.statement;

import ast.python.PythonAstVisitor;

public class BreakNode extends StatementNode {

    public BreakNode(int line) {
        super(line);
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Break [line " + line + "]");
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
