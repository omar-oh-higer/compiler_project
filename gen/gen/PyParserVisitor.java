// Generated from grammar/PyParser.g4 by ANTLR 4.13.2
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PyParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PyParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PyParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDecl(PyParser.ImportDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AppInitDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppInitDecl(PyParser.AppInitDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RouteDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRouteDecl(PyParser.RouteDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(PyParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GlobalAssignDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalAssignDecl(PyParser.GlobalAssignDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GlobalIfDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalIfDecl(PyParser.GlobalIfDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FromImport}
	 * labeled alternative in {@link PyParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromImport(PyParser.FromImportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PlainImport}
	 * labeled alternative in {@link PyParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlainImport(PyParser.PlainImportContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#appInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppInit(PyParser.AppInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#routeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRouteDeclaration(PyParser.RouteDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#routeDecorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRouteDecorator(PyParser.RouteDecoratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(PyParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(PyParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(PyParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(PyParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(PyParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(PyParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(PyParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WithOpenStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithOpenStmt(PyParser.WithOpenStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(PyParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(PyParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(PyParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(PyParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(PyParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(PyParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PyParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#withOpenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithOpenStatement(PyParser.WithOpenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(PyParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#assignOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignOp(PyParser.AssignOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(PyParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(PyParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#globalAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalAssignment(PyParser.GlobalAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PyParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(PyParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(PyParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(PyParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#comparisonExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpr(PyParser.ComparisonExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(PyParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(PyParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpr(PyParser.MultiplicativeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(PyParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#postfixExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpr(PyParser.PostfixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexTrailer}
	 * labeled alternative in {@link PyParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexTrailer(PyParser.IndexTrailerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrTrailer}
	 * labeled alternative in {@link PyParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrTrailer(PyParser.AttrTrailerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallTrailer}
	 * labeled alternative in {@link PyParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallTrailer(PyParser.CallTrailerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NameAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameAtom(PyParser.NameAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(PyParser.NumberAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(PyParser.StringAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrueAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueAtom(PyParser.TrueAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalseAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseAtom(PyParser.FalseAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NoneAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneAtom(PyParser.NoneAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListAtom(PyParser.ListAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DictAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictAtom(PyParser.DictAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenAtom(PyParser.ParenAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#callArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallArguments(PyParser.CallArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#callArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallArgument(PyParser.CallArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyParser#dictItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictItem(PyParser.DictItemContext ctx);
}