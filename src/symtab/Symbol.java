package symtab;

public class Symbol {

    public final String name;
    public String type;
    public final int declaredLine;

    public Symbol(String name, String type, int declaredLine) {
        this.name = name;
        this.type = type;
        this.declaredLine = declaredLine;
    }
}
