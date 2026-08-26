package codegen;

import ast.template.DocumentNode;
import ast.template.TemplateAstBaseVisitor;
import ast.template.TemplateAstNode;
import ast.template.css.*;
import ast.template.html.*;
import ast.template.jinja.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The reverse of TemplateAstBuilder: walks a template AST and prints real
 * HTML/Jinja2/CSS source. Block-level nodes (elements, if/for, style rules)
 * write lines to the shared IndentingWriter; inline "value" nodes (text,
 * {{ expr }}, attribute values, Jinja expression pieces) are pure and
 * return the text they represent.
 */
public class TemplateEmitter extends TemplateAstBaseVisitor<String> {

    private final IndentingWriter out = new IndentingWriter(2);

    public String emit(DocumentNode document) {
        document.accept(this);
        return out.toString();
    }

    // ---------------- HTML: block-level (write lines) ----------------

    @Override
    public String visit(DocumentNode node) {
        emitChildren(filterMeaningful(node.children));
        return null;
    }

    @Override
    public String visit(HtmlElementNode node) {
        List<TemplateAstNode> meaningful = filterMeaningful(node.children);
        String attrs = attrsText(node.attributes);
        if (meaningful.size() == 1 && isInlineable(meaningful.get(0))) {
            out.line("<" + node.tagName + attrs + ">" + inlineText(meaningful.get(0)) + "</" + node.tagName + ">");
            return null;
        }
        out.line("<" + node.tagName + attrs + ">");
        out.indent();
        emitChildren(meaningful);
        out.dedent();
        out.line("</" + node.tagName + ">");
        return null;
    }

    @Override
    public String visit(VoidElementNode node) {
        out.line("<" + node.tagName + attrsText(node.attributes) + ">");
        return null;
    }

    @Override
    public String visit(DoctypeNode node) {
        out.line("<!DOCTYPE " + node.rawName + ">");
        return null;
    }

    @Override
    public String visit(CommentNode node) {
        out.line("<!--" + node.text + "-->");
        return null;
    }

    private void emitChildren(List<TemplateAstNode> children) {
        for (TemplateAstNode child : children) {
            if (child instanceof TextSegmentNode text) {
                out.line(text.text.strip());
            } else if (child instanceof JinjaExpressionNode expr) {
                out.line(expr.accept(this));
            } else {
                child.accept(this); // block-level node self-emits via `out`
            }
        }
    }

    // whitespace-only TEXT nodes are pure formatting from the original
    // source, not content — the emitter produces its own formatting.
    private List<TemplateAstNode> filterMeaningful(List<TemplateAstNode> children) {
        List<TemplateAstNode> result = new ArrayList<>();
        for (TemplateAstNode child : children) {
            if (child instanceof TextSegmentNode text && text.text.strip().isEmpty()) {
                continue;
            }
            result.add(child);
        }
        return result;
    }

    private boolean isInlineable(TemplateAstNode node) {
        return node instanceof TextSegmentNode || node instanceof JinjaExpressionNode;
    }

    private String inlineText(TemplateAstNode node) {
        if (node instanceof TextSegmentNode text) {
            return text.text.strip();
        }
        return node.accept(this); // JinjaExpressionNode
    }

    // ---------------- HTML: attributes (pure — return text) ----------------

    private String attrsText(List<AttributeNode> attributes) {
        StringBuilder sb = new StringBuilder();
        for (AttributeNode attr : attributes) {
            sb.append(' ').append(attr.accept(this));
        }
        return sb.toString();
    }

    @Override
    public String visit(AttributeNode node) {
        return node.value == null ? node.name : (node.name + "=" + node.value.accept(this));
    }

    @Override
    public String visit(AttributeValueNode node) {
        StringBuilder sb = new StringBuilder("\"");
        for (TemplateAstNode part : node.parts) {
            if (part instanceof TextSegmentNode text) {
                sb.append(text.text);
            } else {
                sb.append(part.accept(this)); // JinjaExpressionNode
            }
        }
        return sb.append('"').toString();
    }

    // ---------------- CSS ----------------

    @Override
    public String visit(StyleBlockNode node) {
        out.line("<style>");
        out.indent();
        for (CssRuleNode rule : node.rules) {
            rule.accept(this);
        }
        out.dedent();
        out.line("</style>");
        return null;
    }

    @Override
    public String visit(CssRuleNode node) {
        out.line(node.selector.accept(this) + " {");
        out.indent();
        for (CssPropertyNode prop : node.properties) {
            prop.accept(this);
        }
        out.dedent();
        out.line("}");
        return null;
    }

    @Override
    public String visit(CssSelectorNode node) {
        StringBuilder sb = new StringBuilder();
        if (node.tagName != null) sb.append(node.tagName);
        if (node.className != null) sb.append('.').append(node.className);
        if (node.pseudoClass != null) sb.append(':').append(node.pseudoClass);
        return sb.toString();
    }

    @Override
    public String visit(CssPropertyNode node) {
        out.line(node.name + ": " + String.join(" ", node.valueParts) + ";");
        return null;
    }

    // ---------------- Jinja tags (block-level) ----------------

    @Override
    public String visit(JinjaIfNode node) {
        for (int i = 0; i < node.branches.size(); i++) {
            JinjaIfNode.Branch branch = node.branches.get(i);
            String keyword = (i == 0) ? "if" : "elif";
            out.line("{% " + keyword + " " + branch.condition.accept(this) + " %}");
            out.indent();
            emitChildren(filterMeaningful(branch.body));
            out.dedent();
        }
        if (node.elseBody != null) {
            out.line("{% else %}");
            out.indent();
            emitChildren(filterMeaningful(node.elseBody));
            out.dedent();
        }
        out.line("{% endif %}");
        return null;
    }

    @Override
    public String visit(JinjaForNode node) {
        out.line("{% for " + node.loopVar + " in " + node.iterable.accept(this) + " %}");
        out.indent();
        emitChildren(filterMeaningful(node.body));
        out.dedent();
        if (node.elseBody != null) {
            out.line("{% else %}");
            out.indent();
            emitChildren(filterMeaningful(node.elseBody));
            out.dedent();
        }
        out.line("{% endfor %}");
        return null;
    }

    // ---------------- Jinja expressions (pure — return text) ----------------

    @Override
    public String visit(JinjaExpressionNode node) {
        StringBuilder sb = new StringBuilder("{{ ").append(node.expr.accept(this));
        for (FilterNode filter : node.filters) {
            sb.append(' ').append(filter.accept(this));
        }
        return sb.append(" }}").toString();
    }

    @Override
    public String visit(FilterNode node) {
        if (node.args.isEmpty()) {
            return "| " + node.name;
        }
        String args = node.args.stream().map(a -> a.accept(this)).collect(Collectors.joining(", "));
        return "| " + node.name + "(" + args + ")";
    }

    @Override
    public String visit(JinjaBinaryOpNode node) {
        return wrapIfCompound(node.left) + " " + node.op + " " + wrapIfCompound(node.right);
    }

    @Override
    public String visit(JinjaNotNode node) {
        return "not " + wrapIfCompound(node.operand);
    }

    private String wrapIfCompound(JinjaExprNode node) {
        String text = node.accept(this);
        return (node instanceof JinjaBinaryOpNode || node instanceof JinjaNotNode) ? ("(" + text + ")") : text;
    }

    @Override
    public String visit(JinjaPathNode node) {
        return String.join(".", node.parts);
    }

    @Override
    public String visit(JinjaLiteralNode node) {
        return node.kind.equals("STRING") ? ("\"" + node.value + "\"") : node.value;
    }
}
