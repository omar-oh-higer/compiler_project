package dev;

import ast.core.AstPrinter;
import ast.python.ProgramNode;
import ast.template.DocumentNode;
import errors.*;
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
import java.util.Set;

/**
 * Phase 5 development harness: (a) runs full semantic analysis + linking on
 * the real, clean samples and checks zero errors; (b) runs each
 * samples/negative/ case and checks that EXACTLY the intended exception
 * type (and, for TypeConflictException, the intended Kind) was thrown —
 * not just "some error happened". This class is temporary — Phase 7 folds
 * this pipeline into Main.
 */
public class SemanticAnalysisDemo {

    public static void main(String[] args) throws IOException {
        boolean allOk = true;

        allOk &= runCleanCheck();

        allOk &= expectPythonError(Path.of("samples/negative/unresolved_identifier.py"),
                UnresolvedIdentifierException.class, null);
        allOk &= expectPythonError(Path.of("samples/negative/scope_violation.py"),
                ScopeViolationException.class, null);
        allOk &= expectPythonError(Path.of("samples/negative/not_callable.py"),
                TypeConflictException.class, TypeConflictException.Kind.NOT_CALLABLE);
        allOk &= expectPythonError(Path.of("samples/negative/not_iterable.py"),
                TypeConflictException.class, TypeConflictException.Kind.NOT_ITERABLE);
        allOk &= expectPythonError(Path.of("samples/negative/duplicate_route.py"),
                DuplicateRoutePathException.class, null);
        allOk &= expectPythonError(Path.of("samples/negative/loop_var_shadow.py"),
                LoopVariableShadowException.class, null);

        allOk &= expectTemplateError(Path.of("samples/negative/jinja_loop_scope.html"),
                JinjaLoopScopeError.class);

        allOk &= expectCrossTreeError(
                Path.of("samples/negative/schema_mismatch/app.src.py"),
                Path.of("samples/negative/schema_mismatch/templates_src/item.html"),
                "item.html", TemplateSchemaMismatchException.class);
        allOk &= expectCrossTreeError(
                Path.of("samples/negative/unbound_template_var/app.src.py"),
                Path.of("samples/negative/unbound_template_var/templates_src/greeting.html"),
                "greeting.html", DataBindingUnresolvedException.class);

        System.out.println();
        System.out.println(allOk ? ">>> ALL SEMANTIC CHECKS PASSED <<<" : ">>> SOME SEMANTIC CHECKS FAILED <<<");
        if (!allOk) {
            System.exit(1);
        }
    }

    // ---------------- clean-sample check ----------------

    private static boolean runCleanCheck() throws IOException {
        boolean ok = true;

        ProgramNode pythonAst = parsePython(Path.of("samples/products_app.src.py"));
        PythonSemanticAnalyzer pythonAnalyzer = new PythonSemanticAnalyzer();
        try {
            pythonAnalyzer.analyze(pythonAst);
            System.out.println("[products_app.src.py] OK — no semantic errors");
        } catch (RuntimeException e) {
            System.out.println("[products_app.src.py] FAIL — unexpected " + e.getClass().getSimpleName()
                    + ": " + e.getMessage());
            ok = false;
        }

        Set<String> schema = ProductSchemaInference.infer(pythonAst);
        System.out.println("Inferred product schema: " + schema);

        String[] templateFiles = {"products.html", "add_product.html", "product_details.html", "edit_product.html"};
        for (String name : templateFiles) {
            Path path = Path.of("samples/templates_src/" + name);
            DocumentNode doc = parseTemplate(path);
            TemplateSemanticAnalyzer templateAnalyzer = new TemplateSemanticAnalyzer(name);
            try {
                templateAnalyzer.analyze(doc);
                CrossTreeLinker.link(name, templateAnalyzer, pythonAnalyzer.getRenderTemplateCalls(), schema);
                System.out.println("[" + name + "] OK — no semantic errors, all variables bound and fields valid");
            } catch (RuntimeException e) {
                System.out.println("[" + name + "] FAIL — unexpected " + e.getClass().getSimpleName()
                        + ": " + e.getMessage());
                ok = false;
            }
        }

        System.out.println();
        AstPrinter.printTreeWithSymbols(pythonAst, pythonAnalyzer.getGlobalScope(), "Python: products_app.src.py");

        DocumentNode productsDoc = parseTemplate(Path.of("samples/templates_src/products.html"));
        TemplateSemanticAnalyzer productsAnalyzer = new TemplateSemanticAnalyzer("products.html");
        productsAnalyzer.analyze(productsDoc);
        AstPrinter.printTreeWithSymbols(productsDoc, productsAnalyzer.getRootScope(), "Template: products.html");
        System.out.println();

        return ok;
    }

    // ---------------- negative-sample checks ----------------

    private static boolean expectPythonError(Path file, Class<? extends RuntimeException> expectedClass,
                                              TypeConflictException.Kind expectedKind) throws IOException {
        ProgramNode ast = parsePython(file);
        try {
            new PythonSemanticAnalyzer().analyze(ast);
            System.out.println("[" + file + "] FAIL — expected " + expectedClass.getSimpleName()
                    + " but no error was thrown");
            return false;
        } catch (RuntimeException e) {
            return checkExpected(file, e, expectedClass, expectedKind);
        }
    }

    private static boolean expectTemplateError(Path file, Class<? extends RuntimeException> expectedClass)
            throws IOException {
        DocumentNode doc = parseTemplate(file);
        try {
            new TemplateSemanticAnalyzer(file.toString()).analyze(doc);
            System.out.println("[" + file + "] FAIL — expected " + expectedClass.getSimpleName()
                    + " but no error was thrown");
            return false;
        } catch (RuntimeException e) {
            return checkExpected(file, e, expectedClass, null);
        }
    }

    private static boolean expectCrossTreeError(Path pythonFile, Path templateFile, String templateName,
                                                 Class<? extends RuntimeException> expectedClass) throws IOException {
        ProgramNode pythonAst = parsePython(pythonFile);
        PythonSemanticAnalyzer pythonAnalyzer = new PythonSemanticAnalyzer();
        pythonAnalyzer.analyze(pythonAst);
        Set<String> schema = ProductSchemaInference.infer(pythonAst);

        DocumentNode doc = parseTemplate(templateFile);
        TemplateSemanticAnalyzer templateAnalyzer = new TemplateSemanticAnalyzer(templateName);
        templateAnalyzer.analyze(doc);

        try {
            CrossTreeLinker.link(templateName, templateAnalyzer, pythonAnalyzer.getRenderTemplateCalls(), schema);
            System.out.println("[" + templateFile + "] FAIL — expected " + expectedClass.getSimpleName()
                    + " but no error was thrown");
            return false;
        } catch (RuntimeException e) {
            return checkExpected(templateFile, e, expectedClass, null);
        }
    }

    private static boolean checkExpected(Path file, RuntimeException e, Class<? extends RuntimeException> expectedClass,
                                          TypeConflictException.Kind expectedKind) {
        if (!expectedClass.isInstance(e)) {
            System.out.println("[" + file + "] FAIL — expected " + expectedClass.getSimpleName()
                    + " but got " + e.getClass().getSimpleName() + ": " + e.getMessage());
            return false;
        }
        if (expectedKind != null && ((TypeConflictException) e).kind != expectedKind) {
            System.out.println("[" + file + "] FAIL — expected Kind." + expectedKind
                    + " but got Kind." + ((TypeConflictException) e).kind);
            return false;
        }
        System.out.println("[" + file + "] OK — correctly raised " + e.getClass().getSimpleName()
                + (expectedKind != null ? ("." + expectedKind) : "") + ": " + e.getMessage());
        return true;
    }

    // ---------------- parsing helpers (lexer+parser+AST, no semantic logic) ----------------

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
