package errors;

public class TypeConflictException extends RuntimeException {

    public enum Kind {
        NOT_CALLABLE,
        NOT_ITERABLE,
        ARG_COUNT_MISMATCH,
        REASSIGNED_TYPE,
        BAD_RETURN_TYPE,
        INVALID_OPERATOR_OPERAND
    }

    public final Kind kind;

    public TypeConflictException(Kind kind, String detail, int line) {
        super("Type conflict [" + kind + "] at line " + line + ": " + detail);
        this.kind = kind;
    }
}
