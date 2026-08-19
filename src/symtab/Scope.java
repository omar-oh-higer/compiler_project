package symtab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * One node in a tree of scopes. Deliberately dumb: it knows nothing about
 * "was this name ever defined anywhere historically" — that distinction
 * (used to tell UnresolvedIdentifierException apart from
 * ScopeViolationException) is owned by the semantic analyzer that walks
 * these scopes, not by the scope tree itself.
 */
public class Scope {

    public final Scope parent;
    public final String name;
    private final Map<String, Symbol> rows = new LinkedHashMap<>();
    private final List<Scope> children = new ArrayList<>();

    public Scope(Scope parent, String name) {
        this.parent = parent;
        this.name = name;
        if (parent != null) {
            parent.children.add(this);
        }
    }

    public void define(Symbol symbol) {
        rows.put(symbol.name, symbol);
    }

    public Symbol resolveLocal(String name) {
        return rows.get(name);
    }

    public Symbol resolve(String name) {
        Symbol local = rows.get(name);
        if (local != null) {
            return local;
        }
        return parent != null ? parent.resolve(name) : null;
    }

    public void print(int indent) {
        String pad = "  ".repeat(indent);
        System.out.println(pad + "Scope(" + name + ")");
        for (Symbol symbol : rows.values()) {
            System.out.println(pad + "  " + symbol.name + " : " + symbol.type + " [line " + symbol.declaredLine + "]");
        }
        for (Scope child : children) {
            child.print(indent + 1);
        }
    }
}
