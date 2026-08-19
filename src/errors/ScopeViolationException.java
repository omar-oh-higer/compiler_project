package errors;

/** A name was defined somewhere (e.g. a for-loop variable) but is used
 *  outside the scope where it is actually visible. */
public class ScopeViolationException extends RuntimeException {

    public ScopeViolationException(String name, int line, String currentScope) {
        super("Scope violation: '" + name + "' at line " + line
                + " was defined elsewhere but is not visible in scope '" + currentScope + "'");
    }
}
