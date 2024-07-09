// Generated from agl.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link aglParser}.
 */
public interface aglListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link aglParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(aglParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(aglParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(aglParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(aglParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(aglParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(aglParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void enterInstantiation(aglParser.InstantiationContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void exitInstantiation(aglParser.InstantiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(aglParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(aglParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(aglParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(aglParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link aglParser#view}.
	 * @param ctx the parse tree
	 */
	void enterView(aglParser.ViewContext ctx);
	/**
	 * Exit a parse tree produced by {@link aglParser#view}.
	 * @param ctx the parse tree
	 */
	void exitView(aglParser.ViewContext ctx);
}