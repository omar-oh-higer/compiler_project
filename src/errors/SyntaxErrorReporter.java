package errors;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Collects lexer/parser syntax errors instead of letting ANTLR print its
 * default messages straight to the console, so callers can decide how (and
 * whether) to report them.
 */
public class SyntaxErrorReporter extends BaseErrorListener {

    public static final class SyntaxIssue {
        public final int line;
        public final int column;
        public final String message;

        public SyntaxIssue(int line, int column, String message) {
            this.line = line;
            this.column = column;
            this.message = message;
        }

        @Override
        public String toString() {
            return line + ":" + column + " - " + message;
        }
    }

    private final List<SyntaxIssue> issues = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                             int line, int charPositionInLine, String msg,
                             RecognitionException e) {
        issues.add(new SyntaxIssue(line, charPositionInLine, msg));
    }

    public boolean hasErrors() {
        return !issues.isEmpty();
    }

    public List<SyntaxIssue> getIssues() {
        return issues;
    }

    public void printReport(String sourceLabel) {
        if (issues.isEmpty()) {
            System.out.println("[" + sourceLabel + "] no syntax errors.");
            return;
        }
        System.out.println("[" + sourceLabel + "] " + issues.size() + " syntax error(s):");
        for (SyntaxIssue issue : issues) {
            System.out.println("  " + issue);
        }
    }
}
