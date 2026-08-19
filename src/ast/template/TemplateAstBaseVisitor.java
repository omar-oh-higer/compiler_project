package ast.template;

import ast.template.css.*;
import ast.template.html.*;
import ast.template.jinja.*;

/** Default no-op implementation so callers only override what they need. */
public abstract class TemplateAstBaseVisitor<R> implements TemplateAstVisitor<R> {

    @Override
    public R visit(DocumentNode node) { return null; }

    @Override
    public R visit(DoctypeNode node) { return null; }

    @Override
    public R visit(CommentNode node) { return null; }

    @Override
    public R visit(HtmlElementNode node) { return null; }

    @Override
    public R visit(VoidElementNode node) { return null; }

    @Override
    public R visit(AttributeNode node) { return null; }

    @Override
    public R visit(AttributeValueNode node) { return null; }

    @Override
    public R visit(TextSegmentNode node) { return null; }

    @Override
    public R visit(JinjaIfNode node) { return null; }

    @Override
    public R visit(JinjaForNode node) { return null; }

    @Override
    public R visit(JinjaExpressionNode node) { return null; }

    @Override
    public R visit(FilterNode node) { return null; }

    @Override
    public R visit(JinjaBinaryOpNode node) { return null; }

    @Override
    public R visit(JinjaNotNode node) { return null; }

    @Override
    public R visit(JinjaPathNode node) { return null; }

    @Override
    public R visit(JinjaLiteralNode node) { return null; }

    @Override
    public R visit(StyleBlockNode node) { return null; }

    @Override
    public R visit(CssRuleNode node) { return null; }

    @Override
    public R visit(CssSelectorNode node) { return null; }

    @Override
    public R visit(CssPropertyNode node) { return null; }
}
