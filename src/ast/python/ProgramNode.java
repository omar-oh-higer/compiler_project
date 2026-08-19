package ast.python;

import ast.python.statement.StatementNode;

import java.util.List;

public class ProgramNode extends PythonAstNode {

    public final List<StatementNode> statements;

    public ProgramNode(int line, List<StatementNode> statements) {
        super(line);
        this.statements = statements;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Program(" + statements.size() + " top-level statements)");
        printChildren(statements, indent + 1);
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
