// Generated from grammar/TplParser.g4 by ANTLR 4.13.2
package gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TplParser}.
 */
public interface TplParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TplParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(TplParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(TplParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoctypeNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void enterDoctypeNode(TplParser.DoctypeNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoctypeNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void exitDoctypeNode(TplParser.DoctypeNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CommentNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void enterCommentNode(TplParser.CommentNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CommentNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void exitCommentNode(TplParser.CommentNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VoidElementNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void enterVoidElementNode(TplParser.VoidElementNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VoidElementNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void exitVoidElementNode(TplParser.VoidElementNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElementNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void enterElementNode(TplParser.ElementNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElementNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void exitElementNode(TplParser.ElementNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StyleNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void enterStyleNode(TplParser.StyleNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StyleNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void exitStyleNode(TplParser.StyleNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void enterIfNode(TplParser.IfNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void exitIfNode(TplParser.IfNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void enterForNode(TplParser.ForNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void exitForNode(TplParser.ForNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void enterExprNode(TplParser.ExprNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void exitExprNode(TplParser.ExprNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void enterTextNode(TplParser.TextNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextNode}
	 * labeled alternative in {@link TplParser#node}.
	 * @param ctx the parse tree
	 */
	void exitTextNode(TplParser.TextNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#doctype}.
	 * @param ctx the parse tree
	 */
	void enterDoctype(TplParser.DoctypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#doctype}.
	 * @param ctx the parse tree
	 */
	void exitDoctype(TplParser.DoctypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#htmlComment}.
	 * @param ctx the parse tree
	 */
	void enterHtmlComment(TplParser.HtmlCommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#htmlComment}.
	 * @param ctx the parse tree
	 */
	void exitHtmlComment(TplParser.HtmlCommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlElement(TplParser.HtmlElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlElement(TplParser.HtmlElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#htmlVoidElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlVoidElement(TplParser.HtmlVoidElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#htmlVoidElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlVoidElement(TplParser.HtmlVoidElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(TplParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(TplParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void enterAttrValue(TplParser.AttrValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void exitAttrValue(TplParser.AttrValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#styleElement}.
	 * @param ctx the parse tree
	 */
	void enterStyleElement(TplParser.StyleElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#styleElement}.
	 * @param ctx the parse tree
	 */
	void exitStyleElement(TplParser.StyleElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(TplParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(TplParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void enterCssRule(TplParser.CssRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void exitCssRule(TplParser.CssRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void enterCssSelector(TplParser.CssSelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void exitCssSelector(TplParser.CssSelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#cssProperty}.
	 * @param ctx the parse tree
	 */
	void enterCssProperty(TplParser.CssPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#cssProperty}.
	 * @param ctx the parse tree
	 */
	void exitCssProperty(TplParser.CssPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValue(TplParser.CssValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValue(TplParser.CssValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#cssValueItem}.
	 * @param ctx the parse tree
	 */
	void enterCssValueItem(TplParser.CssValueItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#cssValueItem}.
	 * @param ctx the parse tree
	 */
	void exitCssValueItem(TplParser.CssValueItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#jinjaExprTag}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExprTag(TplParser.JinjaExprTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#jinjaExprTag}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExprTag(TplParser.JinjaExprTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#jFilter}.
	 * @param ctx the parse tree
	 */
	void enterJFilter(TplParser.JFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#jFilter}.
	 * @param ctx the parse tree
	 */
	void exitJFilter(TplParser.JFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#jFilterArgs}.
	 * @param ctx the parse tree
	 */
	void enterJFilterArgs(TplParser.JFilterArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#jFilterArgs}.
	 * @param ctx the parse tree
	 */
	void exitJFilterArgs(TplParser.JFilterArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#jinjaIfStmt}.
	 * @param ctx the parse tree
	 */
	void enterJinjaIfStmt(TplParser.JinjaIfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#jinjaIfStmt}.
	 * @param ctx the parse tree
	 */
	void exitJinjaIfStmt(TplParser.JinjaIfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#jinjaForStmt}.
	 * @param ctx the parse tree
	 */
	void enterJinjaForStmt(TplParser.JinjaForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#jinjaForStmt}.
	 * @param ctx the parse tree
	 */
	void exitJinjaForStmt(TplParser.JinjaForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExpr(TplParser.JinjaExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExpr(TplParser.JinjaExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#jOr}.
	 * @param ctx the parse tree
	 */
	void enterJOr(TplParser.JOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#jOr}.
	 * @param ctx the parse tree
	 */
	void exitJOr(TplParser.JOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#jAnd}.
	 * @param ctx the parse tree
	 */
	void enterJAnd(TplParser.JAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#jAnd}.
	 * @param ctx the parse tree
	 */
	void exitJAnd(TplParser.JAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#jNot}.
	 * @param ctx the parse tree
	 */
	void enterJNot(TplParser.JNotContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#jNot}.
	 * @param ctx the parse tree
	 */
	void exitJNot(TplParser.JNotContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#jComparison}.
	 * @param ctx the parse tree
	 */
	void enterJComparison(TplParser.JComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#jComparison}.
	 * @param ctx the parse tree
	 */
	void exitJComparison(TplParser.JComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link TplParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(TplParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TplParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(TplParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PathAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 */
	void enterPathAtom(TplParser.PathAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PathAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 */
	void exitPathAtom(TplParser.PathAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 */
	void enterNumberAtom(TplParser.NumberAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 */
	void exitNumberAtom(TplParser.NumberAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(TplParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(TplParser.StringAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 */
	void enterTrueAtom(TplParser.TrueAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 */
	void exitTrueAtom(TplParser.TrueAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 */
	void enterFalseAtom(TplParser.FalseAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 */
	void exitFalseAtom(TplParser.FalseAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NoneAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 */
	void enterNoneAtom(TplParser.NoneAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NoneAtom}
	 * labeled alternative in {@link TplParser#jAtomPath}.
	 * @param ctx the parse tree
	 */
	void exitNoneAtom(TplParser.NoneAtomContext ctx);
}