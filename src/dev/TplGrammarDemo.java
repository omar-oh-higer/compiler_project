package dev;

import errors.SyntaxErrorReporter;
import gen.TplLexer;
import gen.TplParser;
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
 * Phase 3 development harness: lexes + parses TplLexer/TplParser sources
 * (HTML/Jinja2/CSS) and prints the token stream and parse tree so the
 * grammar (and its lexer-mode transitions) can be inspected by eye. This
 * class is temporary — Phase 7 folds this pipeline into Main.
 */
public class TplGrammarDemo {

    public static void main(String[] args) throws IOException {
        List<Path> files = new ArrayList<>();
        if (args.length > 0) {
            for (String a : args) {
                files.add(Path.of(a));
            }
        } else {
            files.add(Path.of("samples/templates_src/products.html"));
            files.add(Path.of("samples/templates_src/add_product.html"));
            files.add(Path.of("samples/templates_src/product_details.html"));
            files.add(Path.of("samples/templates_src/edit_product.html"));
            files.add(Path.of("samples/styles_src/main.css"));
            files.add(Path.of("samples/phase3_smoke/mixed_attr_jinja.html"));
            files.add(Path.of("samples/phase3_smoke/deep_nesting.html"));
            files.add(Path.of("samples/phase3_smoke/comment_between_elements.html"));
            files.add(Path.of("samples/phase3_smoke/void_and_regular_mix.html"));
        }

        boolean allOk = true;
        for (int i = 0; i < files.size(); i++) {
            boolean verbose = (i == 0) || (i == 4); // first HTML file + the CSS file
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

        boolean isStylesheet = file.toString().endsWith(".css");

        CharStream input = CharStreams.fromPath(file);

        TplLexer lexer = new TplLexer(input);
        if (isStylesheet) {
            // an external .css file has no <style> wrapper — start the SAME
            // lexer directly in CSS mode instead of DEFAULT (HTML) mode.
            lexer.mode(TplLexer.CSS);
        }
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
                System.out.printf("  line %-4d %-16s %s%n", t.getLine(), typeName, describe(t.getText()));
            }
        }

        TplParser parser = new TplParser(tokens);
        SyntaxErrorReporter parserErrors = new SyntaxErrorReporter();
        parser.removeErrorListeners();
        parser.addErrorListener(parserErrors);

        ParseTree tree = isStylesheet ? parser.stylesheet() : parser.document();

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
