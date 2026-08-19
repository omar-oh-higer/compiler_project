package linking;

import ast.python.ProgramNode;
import ast.python.expression.DictLiteralNode;
import ast.python.expression.ExpressionNode;
import ast.python.expression.ListLiteralNode;
import ast.python.expression.StringNode;
import ast.python.statement.AssignmentNode;
import ast.python.statement.StatementNode;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Infers the "Product" field schema by scanning the Python AST for a
 * top-level list-of-dicts literal (e.g. SEED_PRODUCTS = [ {...}, {...} ])
 * and collecting the union of every dict's string-literal keys.
 */
public final class ProductSchemaInference {

    private ProductSchemaInference() {
    }

    public static Set<String> infer(ProgramNode program) {
        Set<String> fields = new LinkedHashSet<>();
        for (StatementNode stmt : program.statements) {
            if (stmt instanceof AssignmentNode assign && assign.value instanceof ListLiteralNode list) {
                for (ExpressionNode item : list.items) {
                    if (item instanceof DictLiteralNode dict) {
                        for (DictLiteralNode.Entry entry : dict.entries) {
                            if (entry.key instanceof StringNode keyStr) {
                                fields.add(keyStr.value);
                            }
                        }
                    }
                }
            }
        }
        return fields;
    }
}
