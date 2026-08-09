package dev;

import errors.SyntaxErrorReporter;
import gen.PyLexer;
import gen.PyParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Phase 2 development harness: lexes + parses PyLexer/PyParser sources and
 * prints the token stream and parse tree so the grammar can be inspected by
 * eye. This class is temporary — Phase 7 folds this pipeline into Main.
 */
public class PyGrammarDemo {

    public static void main(String[] args) throws IOException {
        List<Path> files = new ArrayList<>();
        if (args.length > 0) {
            for (String a : args) {
                files.add(Path.of(a));
            }
        } else {
            files.add(Path.of("samples/products_app.src.py"));
            files.add(Path.of("samples/phase2_smoke/blank_line_in_block.py"));
            files.add(Path.of("samples/phase2_smoke/comment_in_block.py"));
            files.add(Path.of("samples/phase2_smoke/deep_nesting.py"));
        }

        boolean allOk = true;
        for (int i = 0; i < files.size(); i++) {
            boolean verbose = (i == 0);
            allOk &= runOnFile(files.get(i), verbose);
            System.out.println();
        }

        System.out.println(allOk ? ">>> ALL FILES PARSED SUCCESSFULLY <<<"
                                  : ">>> SOME FILES FAILED TO PARSE <<<");
        if (!allOk) {
            System.exit(1);
        }
    }

    private static boolean runOnFile(Path file, boolean verbose) throws IOException {
        System.out.println("=".repeat(60));
        System.out.println("File: " + file);
        System.out.println("=".repeat(60));

        CharStream input = CharStreams.fromPath(file);

        PyLexer lexer = new PyLexer(input);
        SyntaxErrorReporter lexerErrors = new SyntaxErrorReporter();
        lexer.removeErrorListeners();
        lexer.addErrorListener(lexerErrors);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        if (verbose) {
            System.out.println("--- Tokens ---");
            for (Token t : tokens.getTokens()) {
                if (t.getType() == Token.EOF) {
                    continue;
                }
                String typeName = lexer.getVocabulary().getSymbolicName(t.getType());
                System.out.printf("  line %-4d %-12s %s%n", t.getLine(), typeName, describe(t.getText()));
            }
        }

        PyParser parser = new PyParser(tokens);
        SyntaxErrorReporter parserErrors = new SyntaxErrorReporter();
        parser.removeErrorListeners();
        parser.addErrorListener(parserErrors);

        ParseTree tree = parser.program();

        if (verbose) {
            System.out.println("--- Parse tree ---");
            System.out.println(tree.toStringTree(parser));
        }

        lexerErrors.printReport(file + " [lexer]");
        parserErrors.printReport(file + " [parser]");

        return !lexerErrors.hasErrors() && !parserErrors.hasErrors();
    }

    private static String describe(String text) {
        String normalized = text.replace("\n", "\\n").replace("\t", "\\t");
        return "'" + normalized + "'";
    }
}
