package errors;

import java.util.List;

/** Two @app.route decorators register the exact same (path, methods) pair. */
public class DuplicateRoutePathException extends RuntimeException {

    public DuplicateRoutePathException(String path, List<String> methods, int line) {
        super("Duplicate route: '" + path + "' " + methods + " at line " + line
                + " was already registered by an earlier route");
    }
}
