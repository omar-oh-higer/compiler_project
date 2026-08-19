package visitor;

import ast.template.DocumentNode;
import ast.template.TemplateAstNode;
import ast.template.css.*;
import ast.template.html.*;
import ast.template.jinja.*;
import gen.TplParser;
import gen.TplParserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Walks the ANTLR parse tree produced by TplParser and builds the clean
 * template AST (ast.template.*). Same collapsing idea as PythonAstBuilder:
 * the jOr/jAnd/jNot/jComparison precedence chain becomes plain
 * JinjaBinaryOpNode/JinjaNotNode chains.
 */
public class TemplateAstBuilder extends TplParserBaseVisitor<TemplateAstNode> {

    @Override
    public DocumentNode visitDocument(TplParser.DocumentContext ctx) {
        return new DocumentNode(ctx.getStart().getLine(), buildNodes(ctx.node()));
    }

    // used directly by AstBuilderDemo when parsing an external .css file
    @Override
    public StyleBlockNode visitStylesheet(TplParser.StylesheetContext ctx) {
        return new StyleBlockNode(ctx.getStart().getLine(), buildCssRules(ctx.cssRule()));
    }

    private List<TemplateAstNode> buildNodes(List<TplParser.NodeContext> nodeCtxs) {
        List<TemplateAstNode> result = new ArrayList<>();
        for (TplParser.NodeContext nodeCtx : nodeCtxs) {
            result.add(visit(nodeCtx));
        }
        return result;
    }

    // ---------------- node label wrappers (pure delegation) ----------------

    @Override
    public TemplateAstNode visitDoctypeNode(TplParser.DoctypeNodeContext ctx) {
        return visit(ctx.doctype());
    }

    @Override
    public TemplateAstNode visitCommentNode(TplParser.CommentNodeContext ctx) {
        return visit(ctx.htmlComment());
    }

    @Override
    public TemplateAstNode visitVoidElementNode(TplParser.VoidElementNodeContext ctx) {
        return visit(ctx.htmlVoidElement());
    }

    @Override
    public TemplateAstNode visitElementNode(TplParser.ElementNodeContext ctx) {
        return visit(ctx.htmlElement());
    }

    @Override
    public TemplateAstNode visitStyleNode(TplParser.StyleNodeContext ctx) {
        return visit(ctx.styleElement());
    }

    @Override
    public TemplateAstNode visitIfNode(TplParser.IfNodeContext ctx) {
        return visit(ctx.jinjaIfStmt());
    }

    @Override
    public TemplateAstNode visitForNode(TplParser.ForNodeContext ctx) {
        return visit(ctx.jinjaForStmt());
    }

    @Override
    public TemplateAstNode visitExprNode(TplParser.ExprNodeContext ctx) {
        return visit(ctx.jinjaExprTag());
    }

    @Override
    public TextSegmentNode visitTextNode(TplParser.TextNodeContext ctx) {
        return new TextSegmentNode(ctx.getStart().getLine(), ctx.TEXT().getText());
    }

    // ---------------- HTML ----------------

    @Override
    public DoctypeNode visitDoctype(TplParser.DoctypeContext ctx) {
        return new DoctypeNode(ctx.getStart().getLine(), ctx.TAG_NAME().getText());
    }

    @Override
    public CommentNode visitHtmlComment(TplParser.HtmlCommentContext ctx) {
        StringBuilder text = new StringBuilder();
        for (TerminalNode t : ctx.COMMENT_TEXT()) {
            text.append(t.getText());
        }
        return new CommentNode(ctx.getStart().getLine(), text.toString());
    }

    @Override
    public HtmlElementNode visitHtmlElement(TplParser.HtmlElementContext ctx) {
        String tagName = ctx.TAG_NAME(0).getText();
        List<AttributeNode> attributes = buildAttributes(ctx.attribute());
        List<TemplateAstNode> children = buildNodes(ctx.node());
        int closingLine = ctx.getStop().getLine();
        return new HtmlElementNode(ctx.getStart().getLine(), tagName, attributes, children, closingLine);
    }

    @Override
    public VoidElementNode visitHtmlVoidElement(TplParser.HtmlVoidElementContext ctx) {
        String tagName = ctx.VOID_TAG_NAME().getText();
        List<AttributeNode> attributes = buildAttributes(ctx.attribute());
        return new VoidElementNode(ctx.getStart().getLine(), tagName, attributes);
    }

    private List<AttributeNode> buildAttributes(List<TplParser.AttributeContext> attrCtxs) {
        List<AttributeNode> attributes = new ArrayList<>();
        for (TplParser.AttributeContext attrCtx : attrCtxs) {
            attributes.add(visitAttribute(attrCtx));
        }
        return attributes;
    }

    @Override
    public AttributeNode visitAttribute(TplParser.AttributeContext ctx) {
        String name = ctx.TAG_NAME().getText();
        AttributeValueNode value = ctx.attrValue() != null ? visitAttrValue(ctx.attrValue()) : null;
        return new AttributeNode(ctx.getStart().getLine(), name, value);
    }

    @Override
    public AttributeValueNode visitAttrValue(TplParser.AttrValueContext ctx) {
        // ATTR_TEXT and jinjaExprTag can be mixed in any order, so we walk
        // the actual children instead of the two separately-typed accessors.
        List<TemplateAstNode> parts = new ArrayList<>();
        for (ParseTree child : ctx.children) {
            if (child instanceof TerminalNode term && term.getSymbol().getType() == TplParser.ATTR_TEXT) {
                parts.add(new TextSegmentNode(term.getSymbol().getLine(), term.getText()));
            } else if (child instanceof TplParser.JinjaExprTagContext jinjaCtx) {
                parts.add(visitJinjaExprTag(jinjaCtx));
            }
        }
        return new AttributeValueNode(ctx.getStart().getLine(), parts);
    }

    // ---------------- CSS (shared by <style> and external .css entry point) ----------------

    @Override
    public StyleBlockNode visitStyleElement(TplParser.StyleElementContext ctx) {
        return new StyleBlockNode(ctx.getStart().getLine(), buildCssRules(ctx.cssRule()));
    }

    private List<CssRuleNode> buildCssRules(List<TplParser.CssRuleContext> ruleCtxs) {
        List<CssRuleNode> rules = new ArrayList<>();
        for (TplParser.CssRuleContext ruleCtx : ruleCtxs) {
            rules.add(visitCssRule(ruleCtx));
        }
        return rules;
    }

    @Override
    public CssRuleNode visitCssRule(TplParser.CssRuleContext ctx) {
        CssSelectorNode selector = visitCssSelector(ctx.cssSelector());
        List<CssPropertyNode> properties = new ArrayList<>();
        for (TplParser.CssPropertyContext propCtx : ctx.cssProperty()) {
            properties.add(visitCssProperty(propCtx));
        }
        return new CssRuleNode(ctx.getStart().getLine(), selector, properties);
    }

    @Override
    public CssSelectorNode visitCssSelector(TplParser.CssSelectorContext ctx) {
        List<TerminalNode> idents = ctx.CSS_IDENT();
        boolean startsWithDot = ctx.getChild(0).getText().equals(".");
        boolean hasPseudo = ctx.COLON() != null;

        // a trailing COLON IDENT is always the pseudo-class, never a class
        // name — e.g. "a:hover" is tag=a, pseudo=hover, with NO dot at all.
        int pseudoIndex = hasPseudo ? idents.size() - 1 : -1;
        String pseudoClass = hasPseudo ? idents.get(pseudoIndex).getText() : null;

        String tagName = null;
        int classStart = 0;
        if (!startsWithDot) {
            tagName = idents.get(0).getText();
            classStart = 1;
        }
        int classEnd = hasPseudo ? pseudoIndex : idents.size();
        String className = classStart < classEnd ? idents.get(classStart).getText() : null;

        return new CssSelectorNode(ctx.getStart().getLine(), tagName, className, pseudoClass);
    }

    @Override
    public CssPropertyNode visitCssProperty(TplParser.CssPropertyContext ctx) {
        String name = ctx.CSS_IDENT().getText();
        List<String> valueParts = new ArrayList<>();
        for (TplParser.CssValueItemContext itemCtx : ctx.cssValue().cssValueItem()) {
            valueParts.add(itemCtx.getText());
        }
        return new CssPropertyNode(ctx.getStart().getLine(), name, valueParts);
    }

    // ---------------- Jinja tags ----------------

    @Override
    public JinjaExpressionNode visitJinjaExprTag(TplParser.JinjaExprTagContext ctx) {
        JinjaExprNode expr = (JinjaExprNode) visit(ctx.jinjaExpr());
        List<FilterNode> filters = new ArrayList<>();
        for (TplParser.JFilterContext filterCtx : ctx.jFilter()) {
            filters.add(visitJFilter(filterCtx));
        }
        return new JinjaExpressionNode(ctx.getStart().getLine(), expr, filters);
    }

    @Override
    public FilterNode visitJFilter(TplParser.JFilterContext ctx) {
        String name = ctx.IDENT().getText();
        List<JinjaExprNode> args = new ArrayList<>();
        if (ctx.jFilterArgs() != null) {
            for (TplParser.JinjaExprContext exprCtx : ctx.jFilterArgs().jinjaExpr()) {
                args.add((JinjaExprNode) visit(exprCtx));
            }
        }
        return new FilterNode(ctx.getStart().getLine(), name, args);
    }

    // {% if %}/{% elif %}/{% else %}/{% endif %} share one flat ctx.node()
    // list with no per-branch grouping, so we walk children and split on
    // the IF/ELIF/ELSE/ENDIF boundary tokens ourselves.
    @Override
    public JinjaIfNode visitJinjaIfStmt(TplParser.JinjaIfStmtContext ctx) {
        List<JinjaIfNode.Branch> branches = new ArrayList<>();
        List<TemplateAstNode> elseBody = null;

        JinjaExprNode pendingCondition = null;
        List<TemplateAstNode> currentBody = null;

        for (ParseTree child : ctx.children) {
            if (child instanceof TerminalNode term) {
                int type = term.getSymbol().getType();
                if (type == TplParser.IF || type == TplParser.ELIF) {
                    if (pendingCondition != null) {
                        branches.add(new JinjaIfNode.Branch(pendingCondition, currentBody));
                    }
                    pendingCondition = null;
                    currentBody = new ArrayList<>();
                } else if (type == TplParser.ELSE) {
                    if (pendingCondition != null) {
                        branches.add(new JinjaIfNode.Branch(pendingCondition, currentBody));
                        pendingCondition = null;
                    }
                    elseBody = new ArrayList<>();
                    currentBody = elseBody;
                } else if (type == TplParser.ENDIF) {
                    if (pendingCondition != null) {
                        branches.add(new JinjaIfNode.Branch(pendingCondition, currentBody));
                        pendingCondition = null;
                    }
                }
            } else if (child instanceof TplParser.JinjaExprContext exprCtx) {
                pendingCondition = (JinjaExprNode) visit(exprCtx);
            } else if (child instanceof TplParser.NodeContext nodeCtx) {
                currentBody.add(visit(nodeCtx));
            }
        }

        return new JinjaIfNode(ctx.getStart().getLine(), branches, elseBody);
    }

    // {% for %}...{% else %}...{% endfor %} only has one possible split
    // point (ELSE), so this is simpler than the if/elif/else walker above.
    @Override
    public JinjaForNode visitJinjaForStmt(TplParser.JinjaForStmtContext ctx) {
        String loopVar = ctx.IDENT().getText();
        JinjaExprNode iterable = (JinjaExprNode) visit(ctx.jinjaExpr());

        List<TemplateAstNode> body = new ArrayList<>();
        List<TemplateAstNode> elseBody = null;
        List<TemplateAstNode> currentBody = body;

        for (ParseTree child : ctx.children) {
            if (child instanceof TerminalNode term && term.getSymbol().getType() == TplParser.ELSE) {
                elseBody = new ArrayList<>();
                currentBody = elseBody;
            } else if (child instanceof TplParser.NodeContext nodeCtx) {
                currentBody.add(visit(nodeCtx));
            }
        }

        return new JinjaForNode(ctx.getStart().getLine(), loopVar, iterable, body, elseBody);
    }

    // ---------------- Jinja expressions: precedence chain collapsed ----------------

    @Override
    public TemplateAstNode visitJinjaExpr(TplParser.JinjaExprContext ctx) {
        return visit(ctx.jOr());
    }

    @Override
    public JinjaExprNode visitJOr(TplParser.JOrContext ctx) {
        List<TplParser.JAndContext> operands = ctx.jAnd();
        JinjaExprNode result = (JinjaExprNode) visit(operands.get(0));
        for (int i = 1; i < operands.size(); i++) {
            result = new JinjaBinaryOpNode(ctx.getStart().getLine(), result, "or", (JinjaExprNode) visit(operands.get(i)));
        }
        return result;
    }

    @Override
    public JinjaExprNode visitJAnd(TplParser.JAndContext ctx) {
        List<TplParser.JNotContext> operands = ctx.jNot();
        JinjaExprNode result = (JinjaExprNode) visit(operands.get(0));
        for (int i = 1; i < operands.size(); i++) {
            result = new JinjaBinaryOpNode(ctx.getStart().getLine(), result, "and", (JinjaExprNode) visit(operands.get(i)));
        }
        return result;
    }

    @Override
    public JinjaExprNode visitJNot(TplParser.JNotContext ctx) {
        if (ctx.NOT() != null) {
            return new JinjaNotNode(ctx.getStart().getLine(), (JinjaExprNode) visit(ctx.jNot()));
        }
        return (JinjaExprNode) visit(ctx.jComparison());
    }

    @Override
    public JinjaExprNode visitJComparison(TplParser.JComparisonContext ctx) {
        List<TplParser.JAtomPathContext> operands = ctx.jAtomPath();
        JinjaExprNode result = (JinjaExprNode) visit(operands.get(0));
        if (ctx.compOp() != null) {
            JinjaExprNode right = (JinjaExprNode) visit(operands.get(1));
            result = new JinjaBinaryOpNode(ctx.getStart().getLine(), result, ctx.compOp().getText(), right);
        }
        return result;
    }

    @Override
    public JinjaPathNode visitPathAtom(TplParser.PathAtomContext ctx) {
        List<String> parts = new ArrayList<>();
        for (TerminalNode id : ctx.IDENT()) {
            parts.add(id.getText());
        }
        return new JinjaPathNode(ctx.getStart().getLine(), parts);
    }

    @Override
    public JinjaLiteralNode visitNumberAtom(TplParser.NumberAtomContext ctx) {
        return new JinjaLiteralNode(ctx.getStart().getLine(), ctx.NUMBER().getText(), "NUMBER");
    }

    @Override
    public JinjaLiteralNode visitStringAtom(TplParser.StringAtomContext ctx) {
        return new JinjaLiteralNode(ctx.getStart().getLine(), stripQuotes(ctx.STRING().getText()), "STRING");
    }

    @Override
    public JinjaLiteralNode visitTrueAtom(TplParser.TrueAtomContext ctx) {
        return new JinjaLiteralNode(ctx.getStart().getLine(), "True", "BOOL");
    }

    @Override
    public JinjaLiteralNode visitFalseAtom(TplParser.FalseAtomContext ctx) {
        return new JinjaLiteralNode(ctx.getStart().getLine(), "False", "BOOL");
    }

    @Override
    public JinjaLiteralNode visitNoneAtom(TplParser.NoneAtomContext ctx) {
        return new JinjaLiteralNode(ctx.getStart().getLine(), "None", "NONE");
    }

    private String stripQuotes(String raw) {
        return raw.length() >= 2 ? raw.substring(1, raw.length() - 1) : raw;
    }
}
