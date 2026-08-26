package dev;

import ast.python.ProgramNode;
import ast.template.DocumentNode;
import codegen.CodeGenerator;
import errors.SyntaxErrorReporter;
import gen.PyLexer;
import gen.PyParser;
import gen.TplLexer;
import gen.TplParser;
import linking.CrossTreeLinker;
import linking.ProductSchemaInference;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import semantic.PythonSemanticAnalyzer;
import semantic.TemplateSemanticAnalyzer;
import visitor.PythonAstBuilder;
import visitor.TemplateAstBuilder;

import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Phase 6 development harness: reruns the full Phase 2-5 pipeline
 * (lex -> parse -> AST -> semantic analysis -> linking) on the real samples,
 * refuses to generate anything if that isn't 100% clean, then calls
 * CodeGenerator to write compiler_project/output/. This class is temporary
 * — Phase 7 folds this pipeline into Main.
 */
public class CodeGenDemo {

    private static final String[] TEMPLATE_NAMES = {
            "products.html", "add_product.html", "product_details.html", "edit_product.html"
    };

    public static void main(String[] args) throws IOException {
        ProgramNode pythonAst = parsePython(Path.of("samples/products_app.src.py"));
        PythonSemanticAnalyzer pythonAnalyzer = new PythonSemanticAnalyzer();
        pythonAnalyzer.analyze(pythonAst);
        System.out.println("[products_app.src.py] semantic analysis OK");

        Set<String> schema = ProductSchemaInference.infer(pythonAst);

        Map<String, DocumentNode> templates = new LinkedHashMap<>();
        for (String name : TEMPLATE_NAMES) {
            DocumentNode doc = parseTemplate(Path.of("samples/templates_src/" + name));
            TemplateSemanticAnalyzer templateAnalyzer = new TemplateSemanticAnalyzer(name);
            templateAnalyzer.analyze(doc);
            CrossTreeLinker.link(name, templateAnalyzer, pythonAnalyzer.getRenderTemplateCalls(), schema);
            System.out.println("[" + name + "] semantic analysis + linking OK");
            templates.put(name, doc);
        }

        Path outputDir = Path.of("output");
        CodeGenerator.generate(pythonAst, templates, outputDir);

        System.out.println();
        System.out.println(">>> GENERATED: " + outputDir.resolve("app.py"));
        for (String name : TEMPLATE_NAMES) {
            System.out.println(">>> GENERATED: " + outputDir.resolve("templates").resolve(name));
        }
        System.out.println(">>> GENERATED: " + outputDir.resolve("data").resolve("products.json"));
        System.out.println();
        System.out.println(">>> CODE GENERATION COMPLETE <<<");
    }

    private static ProgramNode parsePython(Path file) throws IOException {
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
        if (lexerErrors.hasErrors() || parserErrors.hasErrors()) {
            throw new IllegalStateException("Unexpected syntax error(s) in " + file);
        }
        return new PythonAstBuilder().visitProgram(tree);
    }

    private static DocumentNode parseTemplate(Path file) throws IOException {
        CharStream input = CharStreams.fromPath(file);
        TplLexer lexer = new TplLexer(input);
        SyntaxErrorReporter lexerErrors = new SyntaxErrorReporter();
        lexer.removeErrorListeners();
        lexer.addErrorListener(lexerErrors);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TplParser parser = new TplParser(tokens);
        SyntaxErrorReporter parserErrors = new SyntaxErrorReporter();
        parser.removeErrorListeners();
        parser.addErrorListener(parserErrors);

        TplParser.DocumentContext tree = parser.document();
        if (lexerErrors.hasErrors() || parserErrors.hasErrors()) {
            throw new IllegalStateException("Unexpected syntax error(s) in " + file);
        }
        return new TemplateAstBuilder().visitDocument(tree);
    }
}
