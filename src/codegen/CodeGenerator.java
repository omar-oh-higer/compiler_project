package codegen;

import ast.python.ProgramNode;
import ast.template.DocumentNode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 * Orchestrates the three emitters and writes their output under outputDir.
 * Assumes both trees already passed semantic analysis (Phase 5) — code
 * generation and verification are deliberately separate concerns here.
 */
public final class CodeGenerator {

    private CodeGenerator() {
    }

    public static void generate(ProgramNode pythonAst, Map<String, DocumentNode> templates, Path outputDir)
            throws IOException {
        Path templatesDir = outputDir.resolve("templates");
        Path dataDir = outputDir.resolve("data");
        Files.createDirectories(templatesDir);
        Files.createDirectories(dataDir);

        writeFile(outputDir.resolve("app.py"), new PythonAppEmitter().emit(pythonAst));

        for (Map.Entry<String, DocumentNode> entry : templates.entrySet()) {
            writeFile(templatesDir.resolve(entry.getKey()), new TemplateEmitter().emit(entry.getValue()));
        }

        writeFile(dataDir.resolve("products.json"), DataFileEmitter.emit(pythonAst));
    }

    private static void writeFile(Path path, String content) throws IOException {
        Files.writeString(path, content, StandardCharsets.UTF_8);
    }
}
