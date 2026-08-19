package semantic;

import ast.template.DocumentNode;
import ast.template.TemplateAstBaseVisitor;
import ast.template.TemplateAstNode;
import ast.template.css.StyleBlockNode;
import ast.template.html.*;
import ast.template.jinja.*;
import errors.JinjaLoopScopeError;
import symtab.Scope;
import symtab.Symbol;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Walks one template's AST and builds its own (independent) Scope tree,
 * where only {% for %} opens a new scope for its loop variable. A "free"
 * name (never a loop variable anywhere in this template) is not an error
 * here — it's expected to come from render_template() on the Python side,
 * so it's just recorded for CrossTreeLinker to check afterwards.
 */
public class TemplateSemanticAnalyzer extends TemplateAstBaseVisitor<Void> {

    public static final class FreeVarUsage {
        public final List<String> pathParts;
        public final int line;

        FreeVarUsage(List<String> pathParts, int line) {
            this.pathParts = pathParts;
            this.line = line;
        }
    }

    private final Scope rootScope;
    private Scope currentScope;
    private final Set<String> everLoopVarNames = new HashSet<>();
    private final List<FreeVarUsage> freeVarUsages = new ArrayList<>();

    public TemplateSemanticAnalyzer(String templateName) {
        this.rootScope = new Scope(null, "template:" + templateName);
        this.currentScope = rootScope;
    }

    public void analyze(DocumentNode document) {
        document.accept(this);
    }

    public Scope getRootScope() {
        return rootScope;
    }

    public List<FreeVarUsage> getFreeVarUsages() {
        return freeVarUsages;
    }

    private void visitAll(List<TemplateAstNode> nodes) {
        for (TemplateAstNode node : nodes) {
            node.accept(this);
        }
    }

    // ---------------- HTML ----------------

    @Override
    public Void visit(DocumentNode node) {
        visitAll(node.children);
        return null;
    }

    @Override
    public Void visit(HtmlElementNode node) {
        for (AttributeNode attr : node.attributes) {
            attr.accept(this);
        }
        visitAll(node.children);
        return null;
    }

    @Override
    public Void visit(VoidElementNode node) {
        for (AttributeNode attr : node.attributes) {
            attr.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(AttributeNode node) {
        if (node.value != null) {
            node.value.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(AttributeValueNode node) {
        visitAll(node.parts);
        return null;
    }

    @Override
    public Void visit(TextSegmentNode node) {
        return null;
    }

    @Override
    public Void visit(DoctypeNode node) {
        return null;
    }

    @Override
    public Void visit(CommentNode node) {
        return null;
    }

    @Override
    public Void visit(StyleBlockNode node) {
        return null; // our grammar never allows Jinja inside CSS values
    }

    // ---------------- Jinja ----------------

    @Override
    public Void visit(JinjaExpressionNode node) {
        node.expr.accept(this);
        for (FilterNode filter : node.filters) {
            filter.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FilterNode node) {
        for (JinjaExprNode arg : node.args) {
            arg.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(JinjaBinaryOpNode node) {
        node.left.accept(this);
        node.right.accept(this);
        return null;
    }

    @Override
    public Void visit(JinjaNotNode node) {
        node.operand.accept(this);
        return null;
    }

    @Override
    public Void visit(JinjaLiteralNode node) {
        return null;
    }

    @Override
    public Void visit(JinjaPathNode node) {
        String root = node.parts.get(0);
        if (currentScope.resolve(root) != null) {
            return null; // a loop variable currently in scope — fine
        }
        if (everLoopVarNames.contains(root)) {
            throw new JinjaLoopScopeError(root, node.line);
        }
        freeVarUsages.add(new FreeVarUsage(node.parts, node.line));
        return null;
    }

    @Override
    public Void visit(JinjaIfNode node) {
        for (JinjaIfNode.Branch branch : node.branches) {
            branch.condition.accept(this);
            visitAll(branch.body);
        }
        if (node.elseBody != null) {
            visitAll(node.elseBody);
        }
        return null;
    }

    @Override
    public Void visit(JinjaForNode node) {
        node.iterable.accept(this);

        Scope forScope = new Scope(currentScope, "for:" + node.loopVar + "@" + node.line);
        forScope.define(new Symbol(node.loopVar, "unknown", node.line));
        everLoopVarNames.add(node.loopVar);

        Scope previousScope = currentScope;
        currentScope = forScope;
        visitAll(node.body);
        currentScope = previousScope;

        if (node.elseBody != null) {
            visitAll(node.elseBody);
        }
        return null;
    }
}
