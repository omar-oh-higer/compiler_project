// Generated from grammar/TplParser.g4 by ANTLR 4.13.2
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TplParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TplParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TplParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(TplParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoctypeNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoctypeNode(TplParser.DoctypeNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CommentNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentNode(TplParser.CommentNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidElementNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidElementNode(TplParser.VoidElementNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElementNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementNode(TplParser.ElementNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StyleNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyleNode(TplParser.StyleNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfNode(TplParser.IfNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForNode(TplParser.ForNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNode(TplParser.ExprNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TextNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextNode(TplParser.TextNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#doctype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoctype(TplParser.DoctypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#htmlComment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlComment(TplParser.HtmlCommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElement(TplParser.HtmlElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#htmlVoidElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlVoidElement(TplParser.HtmlVoidElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(TplParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#attrValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrValue(TplParser.AttrValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#styleElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyleElement(TplParser.StyleElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#stylesheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheet(TplParser.StylesheetContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#cssRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssRule(TplParser.CssRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#cssSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssSelector(TplParser.CssSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#cssProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssProperty(TplParser.CssPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValue(TplParser.CssValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#cssValueItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValueItem(TplParser.CssValueItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#jinjaExprTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExprTag(TplParser.JinjaExprTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#jFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJFilter(TplParser.JFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#jFilterArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJFilterArgs(TplParser.JFilterArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#jinjaIfStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaIfStmt(TplParser.JinjaIfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#jinjaForStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaForStmt(TplParser.JinjaForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExpr(TplParser.JinjaExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#jOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJOr(TplParser.JOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#jAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJAnd(TplParser.JAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#jNot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJNot(TplParser.JNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#jComparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJComparison(TplParser.JComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link TplParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(TplParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PathAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathAtom(TplParser.PathAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(TplParser.NumberAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(TplParser.StringAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrueAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueAtom(TplParser.TrueAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalseAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseAtom(TplParser.FalseAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NoneAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneAtom(TplParser.NoneAtomContext ctx);
}