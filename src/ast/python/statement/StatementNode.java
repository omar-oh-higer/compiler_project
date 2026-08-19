package ast.python.statement;

import ast.python.PythonAstNode;

public abstract class StatementNode extends PythonAstNode {
    protected StatementNode(int line) {
        super(line);
    }
}
