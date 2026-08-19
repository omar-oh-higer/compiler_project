package ast.template.jinja;

import ast.template.TemplateAstVisitor;

import java.util.List;

/** e.g. product.name -> parts = ["product", "name"] */
public class JinjaPathNode extends JinjaExprNode {

    public final List<String> parts;

    public JinjaPathNode(int line, List<String> parts) {
        super(line);
        this.parts = parts;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Path(" + String.join(".", parts) + ") [line " + line + "]");
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
