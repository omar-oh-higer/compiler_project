package errors;

/** A for-loop variable name shadows a name already defined in an outer scope. */
public class LoopVariableShadowException extends RuntimeException {

    public LoopVariableShadowException(String name, int line) {
        super("Loop variable '" + name + "' at line " + line + " shadows an existing outer-scope name");
    }
}
