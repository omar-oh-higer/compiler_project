package errors;

/** A Jinja variable used in a template was never passed by any matching render_template() call. */
public class DataBindingUnresolvedException extends RuntimeException {

    public DataBindingUnresolvedException(String varName, String templateName, int line) {
        super("Variable '" + varName + "' used in '" + templateName + "' at line " + line
                + " was never passed by a render_template() call for that template");
    }
}
