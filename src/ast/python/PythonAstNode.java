package ast.python;

import ast.core.Node;

public abstract class PythonAstNode extends Node {

    protected PythonAstNode(int line) {
        super(line);
    }

    public abstract <R> R accept(PythonAstVisitor<R> visitor);
}
