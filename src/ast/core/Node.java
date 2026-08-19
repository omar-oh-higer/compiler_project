package ast.core;

public abstract class Node implements Printable {

    private static int nextId = 1;

    public final int line;
    public final int id;

    protected Node(int line) {
        this.line = line;
        this.id = nextId++;
    }

    protected static String pad(int indent) {
        return "  ".repeat(indent);
    }

    protected static void printChildren(Iterable<? extends Printable> children, int indent) {
        for (Printable child : children) {
            child.print(indent);
        }
    }

    @Override
    public abstract void print(int indent);
}
