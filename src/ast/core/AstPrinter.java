package ast.core;

import symtab.Scope;

public final class AstPrinter {

    private AstPrinter() {
    }

    public static void printTree(Node root, String title) {
        System.out.println("=== " + title + " ===");
        root.print(0);
    }

    /** Satisfies the "print the whole tree together with the symbol table" requirement. */
    public static void printTreeWithSymbols(Node root, Scope rootScope, String title) {
        System.out.println("=== " + title + " — AST ===");
        root.print(0);
        System.out.println("=== " + title + " — Symbol Table ===");
        rootScope.print(0);
    }
}
