package ast.python.statement;

import ast.python.PythonAstVisitor;
import ast.python.expression.ExpressionNode;

import java.util.List;

public class AppInitNode extends StatementNode {

    public final String varName;
    public final String className;
    public final List<ExpressionNode> args;

    public AppInitNode(int line, String varName, String className, List<ExpressionNode> args) {
        super(line);
        this.varName = varName;
        this.className = className;
        this.args = args;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "AppInit(" + varName + " = " + className + "(...)) [line " + line + "]");
        printChildren(args, indent + 1);
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
