package dev;

import ast.core.AstPrinter;
import ast.python.ProgramNode;
import ast.template.DocumentNode;
import ast.template.css.StyleBlockNode;
import errors.SyntaxErrorReporter;
import gen.PyLexer;
import gen.PyParser;
import gen.TplLexer;
import gen.TplParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import visitor.PythonAstBuilder;
import visitor.TemplateAstBuilder;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Phase 4 development harness: parses the Phase 2/3 samples, runs
 * PythonAstBuilder / TemplateAstBuilder over the parse trees, and prints
 * the resulting AST (instead of the raw parse tree, which is what
 * PyGrammarDemo/TplGrammarDemo print). This class is temporary — Phase 7
 * folds this pipeline into Main.
 */
public class AstBuilderDemo {

    public static void main(String[] args) throws IOException {
        buildPython(Path.of("samples/products_app.src.py"));

        buildTemplate(Path.of("samples/templates_src/products.html"), false);
        buildTemplate(Path.of("samples/templates_src/add_product.html"), false);
        buildTemplate(Path.of("samples/templates_src/product_details.html"), false);
        buildTemplate(Path.of("samples/templates_src/edit_product.html"), false);
        buildTemplate(Path.of("samples/styles_src/main.css"), true);
    }

    private static void buildPython(Path file) throws IOException {
        CharStream input = CharStreams.fromPath(file);
        PyLexer lexer = new PyLexer(input);
        SyntaxErrorReporter lexerErrors = new SyntaxErrorReporter();
        lexer.removeErrorListeners();
        lexer.addErrorListener(lexerErrors);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PyParser parser = new PyParser(tokens);
        SyntaxErrorReporter parserErrors = new SyntaxErrorReporter();
        parser.removeErrorListeners();
        parser.addErrorListener(parserErrors);

        PyParser.ProgramContext tree = parser.program();
        lexerErrors.printReport(file + " [lexer]");
        parserErrors.printReport(file + " [parser]");
        if (lexerErrors.hasErrors() || parserErrors.hasErrors()) {
            return;
        }

        ProgramNode ast = new PythonAstBuilder().visitProgram(tree);
        AstPrinter.printTree(ast, "Python AST: " + file);
        System.out.println();
    }

    private static void buildTemplate(Path file, boolean isStylesheet) throws IOException {
        CharStream input = CharStreams.fromPath(file);
        TplLexer lexer = new TplLexer(input);
        if (isStylesheet) {
            lexer.mode(TplLexer.CSS);
        }
        SyntaxErrorReporter lexerErrors = new SyntaxErrorReporter();
        lexer.removeErrorListeners();
        lexer.addErrorListener(lexerErrors);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TplParser parser = new TplParser(tokens);
        SyntaxErrorReporter parserErrors = new SyntaxErrorReporter();
        parser.removeErrorListeners();
        parser.addErrorListener(parserErrors);

        TemplateAstBuilder builder = new TemplateAstBuilder();

        if (isStylesheet) {
            TplParser.StylesheetContext tree = parser.stylesheet();
            lexerErrors.printReport(file + " [lexer]");
            parserErrors.printReport(file + " [parser]");
            if (lexerErrors.hasErrors() || parserErrors.hasErrors()) {
                return;
            }
            StyleBlockNode ast = builder.visitStylesheet(tree);
            AstPrinter.printTree(ast, "Template AST: " + file);
        } else {
            TplParser.DocumentContext tree = parser.document();
            lexerErrors.printReport(file + " [lexer]");
            parserErrors.printReport(file + " [parser]");
            if (lexerErrors.hasErrors() || parserErrors.hasErrors()) {
                return;
            }
            DocumentNode ast = builder.visitDocument(tree);
            AstPrinter.printTree(ast, "Template AST: " + file);
        }
        System.out.println();
    }
}
