package ast.core;

public final class AstPrinter {

    private AstPrinter() {
    }

    public static void printTree(Node root, String title) {
        System.out.println("=== " + title + " ===");
        root.print(0);
    }
}
