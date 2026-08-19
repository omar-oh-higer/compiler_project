package errors;

/** A Jinja template accesses a field that doesn't exist in the inferred product schema. */
public class TemplateSchemaMismatchException extends RuntimeException {

    public TemplateSchemaMismatchException(String fieldName, String templateName, int line) {
        super("Template schema mismatch: field '" + fieldName + "' at line " + line
                + " in '" + templateName + "' does not exist in the inferred product schema");
    }
}
