package errors;

/** A {% for %} loop variable is used in a Jinja template outside its own loop block. */
public class JinjaLoopScopeError extends RuntimeException {

    public JinjaLoopScopeError(String name, int line) {
        super("Jinja loop variable '" + name + "' at line " + line + " is used outside the {% for %} block that defines it");
    }
}
