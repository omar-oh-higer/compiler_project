package errors;

/** A name is used that was never defined anywhere in the program's history. */
public class UnresolvedIdentifierException extends RuntimeException {

    public UnresolvedIdentifierException(String name, int line) {
        super("Unresolved identifier '" + name + "' at line " + line + " — never defined anywhere");
    }
}
