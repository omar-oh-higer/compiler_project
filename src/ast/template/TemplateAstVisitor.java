package ast.template;

import ast.template.css.*;
import ast.template.html.*;
import ast.template.jinja.*;

public interface TemplateAstVisitor<R> {
    R visit(DocumentNode node);

    R visit(DoctypeNode node);
    R visit(CommentNode node);
    R visit(HtmlElementNode node);
    R visit(VoidElementNode node);
    R visit(AttributeNode node);
    R visit(AttributeValueNode node);
    R visit(TextSegmentNode node);

    R visit(JinjaIfNode node);
    R visit(JinjaForNode node);
    R visit(JinjaExpressionNode node);
    R visit(FilterNode node);
    R visit(JinjaBinaryOpNode node);
    R visit(JinjaNotNode node);
    R visit(JinjaPathNode node);
    R visit(JinjaLiteralNode node);

    R visit(StyleBlockNode node);
    R visit(CssRuleNode node);
    R visit(CssSelectorNode node);
    R visit(CssPropertyNode node);
}
