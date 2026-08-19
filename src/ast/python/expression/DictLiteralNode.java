package ast.python.expression;

import ast.python.PythonAstVisitor;

import java.util.List;

public class DictLiteralNode extends ExpressionNode {

    public static final class Entry {
        public final ExpressionNode key;
        public final ExpressionNode value;

        public Entry(ExpressionNode key, ExpressionNode value) {
            this.key = key;
            this.value = value;
        }

        void print(int indent) {
            System.out.println("  ".repeat(indent) + "Entry:");
            key.print(indent + 1);
            value.print(indent + 1);
        }
    }

    public final List<Entry> entries;

    public DictLiteralNode(int line, List<Entry> entries) {
        super(line);
        this.entries = entries;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Dict(" + entries.size() + " entries) [line " + line + "]");
        for (Entry entry : entries) {
            entry.print(indent + 1);
        }
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
