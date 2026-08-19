package ast.template.jinja;

import ast.template.TemplateAstNode;

/** Common base for the collapsed Jinja expression value nodes (path, literal, not, binary op). */
public abstract class JinjaExprNode extends TemplateAstNode {
    protected JinjaExprNode(int line) {
        super(line);
    }
}
