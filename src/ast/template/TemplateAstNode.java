package ast.template;

import ast.core.Node;

public abstract class TemplateAstNode extends Node {

    protected TemplateAstNode(int line) {
        super(line);
    }

    public abstract <R> R accept(TemplateAstVisitor<R> visitor);
}
