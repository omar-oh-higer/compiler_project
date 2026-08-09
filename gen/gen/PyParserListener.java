// Generated from grammar/PyParser.g4 by ANTLR 4.13.2
package gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PyParser}.
 */
public interface PyParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PyParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PyParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PyParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterImportDecl(PyParser.ImportDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitImportDecl(PyParser.ImportDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AppInitDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAppInitDecl(PyParser.AppInitDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AppInitDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAppInitDecl(PyParser.AppInitDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RouteDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterRouteDecl(PyParser.RouteDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RouteDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitRouteDecl(PyParser.RouteDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(PyParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(PyParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GlobalAssignDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterGlobalAssignDecl(PyParser.GlobalAssignDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GlobalAssignDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitGlobalAssignDecl(PyParser.GlobalAssignDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GlobalIfDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterGlobalIfDecl(PyParser.GlobalIfDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GlobalIfDecl}
	 * labeled alternative in {@link PyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitGlobalIfDecl(PyParser.GlobalIfDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FromImport}
	 * labeled alternative in {@link PyParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterFromImport(PyParser.FromImportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FromImport}
	 * labeled alternative in {@link PyParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitFromImport(PyParser.FromImportContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PlainImport}
	 * labeled alternative in {@link PyParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterPlainImport(PyParser.PlainImportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PlainImport}
	 * labeled alternative in {@link PyParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitPlainImport(PyParser.PlainImportContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#appInit}.
	 * @param ctx the parse tree
	 */
	void enterAppInit(PyParser.AppInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#appInit}.
	 * @param ctx the parse tree
	 */
	void exitAppInit(PyParser.AppInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#routeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterRouteDeclaration(PyParser.RouteDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#routeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitRouteDeclaration(PyParser.RouteDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#routeDecorator}.
	 * @param ctx the parse tree
	 */
	void enterRouteDecorator(PyParser.RouteDecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#routeDecorator}.
	 * @param ctx the parse tree
	 */
	void exitRouteDecorator(PyParser.RouteDecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(PyParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(PyParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(PyParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(PyParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(PyParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(PyParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(PyParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(PyParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(PyParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(PyParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(PyParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(PyParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(PyParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(PyParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WithOpenStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void enterWithOpenStmt(PyParser.WithOpenStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WithOpenStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void exitWithOpenStmt(PyParser.WithOpenStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(PyParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(PyParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(PyParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(PyParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(PyParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link PyParser#stmtInFunction}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(PyParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(PyParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(PyParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(PyParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(PyParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(PyParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(PyParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PyParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PyParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#withOpenStatement}.
	 * @param ctx the parse tree
	 */
	void enterWithOpenStatement(PyParser.WithOpenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#withOpenStatement}.
	 * @param ctx the parse tree
	 */
	void exitWithOpenStatement(PyParser.WithOpenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(PyParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(PyParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void enterAssignOp(PyParser.AssignOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void exitAssignOp(PyParser.AssignOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(PyParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(PyParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(PyParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(PyParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#globalAssignment}.
	 * @param ctx the parse tree
	 */
	void enterGlobalAssignment(PyParser.GlobalAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#globalAssignment}.
	 * @param ctx the parse tree
	 */
	void exitGlobalAssignment(PyParser.GlobalAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PyParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PyParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(PyParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(PyParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(PyParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(PyParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(PyParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(PyParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#comparisonExpr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpr(PyParser.ComparisonExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#comparisonExpr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpr(PyParser.ComparisonExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(PyParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(PyParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(PyParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(PyParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(PyParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(PyParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(PyParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(PyParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpr(PyParser.PostfixExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpr(PyParser.PostfixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexTrailer}
	 * labeled alternative in {@link PyParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterIndexTrailer(PyParser.IndexTrailerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexTrailer}
	 * labeled alternative in {@link PyParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitIndexTrailer(PyParser.IndexTrailerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrTrailer}
	 * labeled alternative in {@link PyParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterAttrTrailer(PyParser.AttrTrailerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrTrailer}
	 * labeled alternative in {@link PyParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitAttrTrailer(PyParser.AttrTrailerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallTrailer}
	 * labeled alternative in {@link PyParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterCallTrailer(PyParser.CallTrailerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallTrailer}
	 * labeled alternative in {@link PyParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitCallTrailer(PyParser.CallTrailerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NameAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNameAtom(PyParser.NameAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NameAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNameAtom(PyParser.NameAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumberAtom(PyParser.NumberAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumberAtom(PyParser.NumberAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(PyParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(PyParser.StringAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterTrueAtom(PyParser.TrueAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitTrueAtom(PyParser.TrueAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterFalseAtom(PyParser.FalseAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitFalseAtom(PyParser.FalseAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NoneAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNoneAtom(PyParser.NoneAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NoneAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNoneAtom(PyParser.NoneAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterListAtom(PyParser.ListAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitListAtom(PyParser.ListAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DictAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterDictAtom(PyParser.DictAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DictAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitDictAtom(PyParser.DictAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParenAtom(PyParser.ParenAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenAtom}
	 * labeled alternative in {@link PyParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParenAtom(PyParser.ParenAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#callArguments}.
	 * @param ctx the parse tree
	 */
	void enterCallArguments(PyParser.CallArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#callArguments}.
	 * @param ctx the parse tree
	 */
	void exitCallArguments(PyParser.CallArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#callArgument}.
	 * @param ctx the parse tree
	 */
	void enterCallArgument(PyParser.CallArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#callArgument}.
	 * @param ctx the parse tree
	 */
	void exitCallArgument(PyParser.CallArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyParser#dictItem}.
	 * @param ctx the parse tree
	 */
	void enterDictItem(PyParser.DictItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyParser#dictItem}.
	 * @param ctx the parse tree
	 */
	void exitDictItem(PyParser.DictItemContext ctx);
}