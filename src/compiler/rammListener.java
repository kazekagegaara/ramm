// Generated from ramm.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link rammParser}.
 */
public interface rammListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link rammParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(rammParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link rammParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(rammParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link rammParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(rammParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link rammParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(rammParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link rammParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(rammParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link rammParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(rammParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link rammParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(rammParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link rammParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(rammParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link rammParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierFunctionCall(rammParser.IdentifierFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link rammParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierFunctionCall(rammParser.IdentifierFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printlnFunctionCall}
	 * labeled alternative in {@link rammParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintlnFunctionCall(rammParser.PrintlnFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printlnFunctionCall}
	 * labeled alternative in {@link rammParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintlnFunctionCall(rammParser.PrintlnFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link rammParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintFunctionCall(rammParser.PrintFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link rammParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintFunctionCall(rammParser.PrintFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assertFunctionCall}
	 * labeled alternative in {@link rammParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterAssertFunctionCall(rammParser.AssertFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assertFunctionCall}
	 * labeled alternative in {@link rammParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitAssertFunctionCall(rammParser.AssertFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sizeFunctionCall}
	 * labeled alternative in {@link rammParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterSizeFunctionCall(rammParser.SizeFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sizeFunctionCall}
	 * labeled alternative in {@link rammParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitSizeFunctionCall(rammParser.SizeFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link rammParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(rammParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link rammParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(rammParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link rammParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(rammParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link rammParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(rammParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link rammParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStat(rammParser.ElseIfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link rammParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStat(rammParser.ElseIfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link rammParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void enterElseStat(rammParser.ElseStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link rammParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void exitElseStat(rammParser.ElseStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link rammParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(rammParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link rammParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(rammParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link rammParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(rammParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link rammParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(rammParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link rammParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(rammParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link rammParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(rammParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link rammParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(rammParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link rammParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(rammParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link rammParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(rammParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link rammParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(rammParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divideExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivideExpression(rammParser.DivideExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divideExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivideExpression(rammParser.DivideExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modulusExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterModulusExpression(rammParser.ModulusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modulusExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitModulusExpression(rammParser.ModulusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpression(rammParser.EqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpression(rammParser.EqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(rammParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(rammParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(rammParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(rammParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powerExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExpression(rammParser.PowerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powerExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExpression(rammParser.PowerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(rammParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(rammParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(rammParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(rammParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLtExpression(rammParser.LtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLtExpression(rammParser.LtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionExpression(rammParser.ExpressionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionExpression(rammParser.ExpressionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNullExpression(rammParser.NullExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNullExpression(rammParser.NullExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inputExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInputExpression(rammParser.InputExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inputExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInputExpression(rammParser.InputExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltEqExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLtEqExpression(rammParser.LtEqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltEqExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLtEqExpression(rammParser.LtEqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(rammParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(rammParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(rammParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(rammParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(rammParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(rammParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gtEqExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGtEqExpression(rammParser.GtEqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gtEqExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGtEqExpression(rammParser.GtEqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notEqExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotEqExpression(rammParser.NotEqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notEqExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotEqExpression(rammParser.NotEqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subtractExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubtractExpression(rammParser.SubtractExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subtractExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubtractExpression(rammParser.SubtractExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(rammParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(rammParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplyExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExpression(rammParser.MultiplyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplyExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExpression(rammParser.MultiplyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gtExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGtExpression(rammParser.GtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gtExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGtExpression(rammParser.GtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(rammParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(rammParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterReturnExpression(rammParser.ReturnExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitReturnExpression(rammParser.ReturnExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpression(rammParser.UnaryMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpression(rammParser.UnaryMinusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(rammParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(rammParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(rammParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(rammParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterListExpression(rammParser.ListExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link rammParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitListExpression(rammParser.ListExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link rammParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(rammParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link rammParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(rammParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link rammParser#indexes}.
	 * @param ctx the parse tree
	 */
	void enterIndexes(rammParser.IndexesContext ctx);
	/**
	 * Exit a parse tree produced by {@link rammParser#indexes}.
	 * @param ctx the parse tree
	 */
	void exitIndexes(rammParser.IndexesContext ctx);
}