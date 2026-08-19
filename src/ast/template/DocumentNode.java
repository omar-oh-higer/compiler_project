package ast.template;

import java.util.List;

public class DocumentNode extends TemplateAstNode {

    public final List<TemplateAstNode> children;

    public DocumentNode(int line, List<TemplateAstNode> children) {
        super(line);
        this.children = children;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Document(" + children.size() + " top-level node(s))");
        printChildren(children, indent + 1);
    }

    @Override
    public <R> R accept(TemplateAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
