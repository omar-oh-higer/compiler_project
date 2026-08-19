package ast.python.expression;

import ast.python.PythonAstNode;

public abstract class ExpressionNode extends PythonAstNode {
    protected ExpressionNode(int line) {
        super(line);
    }
}
