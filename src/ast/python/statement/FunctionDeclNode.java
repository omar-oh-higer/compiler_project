package ast.python.statement;

import ast.python.PythonAstVisitor;

import java.util.List;

public class FunctionDeclNode extends StatementNode {

    public final String name;
    public final List<String> params;
    public final List<StatementNode> body;

    public FunctionDeclNode(int line, String name, List<String> params, List<StatementNode> body) {
        super(line);
        this.name = name;
        this.params = params;
        this.body = body;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "FunctionDecl(" + name + params + ") [line " + line + "]");
        printChildren(body, indent + 1);
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
