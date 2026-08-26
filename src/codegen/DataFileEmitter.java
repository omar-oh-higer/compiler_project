package codegen;

import ast.python.ProgramNode;
import ast.python.expression.*;
import ast.python.statement.AssignmentNode;
import ast.python.statement.StatementNode;

/**
 * Materializes the seed data literal (e.g. SEED_PRODUCTS = [ {...}, {...} ])
 * as a real JSON file — the concrete proof of "passing data from the
 * Python-code array into" a runtime artifact the generated app actually
 * reads (matches load_products()'s json.load(f)["products"] shape).
 */
public final class DataFileEmitter {

    private DataFileEmitter() {
    }

    public static String emit(ProgramNode program) {
        ListLiteralNode seedList = findSeedList(program);
        StringBuilder json = new StringBuilder();
        json.append("{\n  \"products\": ");
        if (seedList == null) {
            json.append("[]\n");
        } else {
            writeValue(json, seedList, 1);
            json.append('\n');
        }
        json.append("}\n");
        return json.toString();
    }

    private static ListLiteralNode findSeedList(ProgramNode program) {
        for (StatementNode stmt : program.statements) {
            if (stmt instanceof AssignmentNode assign && assign.value instanceof ListLiteralNode list) {
                boolean allDicts = !list.items.isEmpty()
                        && list.items.stream().allMatch(item -> item instanceof DictLiteralNode);
                if (allDicts) {
                    return list;
                }
            }
        }
        return null;
    }

    private static void writeValue(StringBuilder out, ExpressionNode node, int depth) {
        if (node instanceof ListLiteralNode list) {
            if (list.items.isEmpty()) {
                out.append("[]");
                return;
            }
            out.append("[\n");
            for (int i = 0; i < list.items.size(); i++) {
                indent(out, depth + 1);
                writeValue(out, list.items.get(i), depth + 1);
                if (i < list.items.size() - 1) {
                    out.append(',');
                }
                out.append('\n');
            }
            indent(out, depth);
            out.append(']');
        } else if (node instanceof DictLiteralNode dict) {
            if (dict.entries.isEmpty()) {
                out.append("{}");
                return;
            }
            out.append("{\n");
            for (int i = 0; i < dict.entries.size(); i++) {
                DictLiteralNode.Entry entry = dict.entries.get(i);
                indent(out, depth + 1);
                writeValue(out, entry.key, depth + 1);
                out.append(": ");
                writeValue(out, entry.value, depth + 1);
                if (i < dict.entries.size() - 1) {
                    out.append(',');
                }
                out.append('\n');
            }
            indent(out, depth);
            out.append('}');
        } else if (node instanceof StringNode str) {
            out.append('"').append(escape(str.value)).append('"');
        } else if (node instanceof NumberNode num) {
            out.append(num.value);
        } else if (node instanceof BoolLiteralNode bool) {
            out.append(bool.value ? "true" : "false");
        } else {
            // NoneLiteralNode or anything non-literal (name ref, call...) has no static JSON value
            out.append("null");
        }
    }

    private static void indent(StringBuilder out, int depth) {
        out.append("  ".repeat(depth));
    }

    private static String escape(String raw) {
        return raw.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
