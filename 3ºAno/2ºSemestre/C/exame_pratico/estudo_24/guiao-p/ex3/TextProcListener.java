// Generated from TextProc.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TextProcParser}.
 */
public interface TextProcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TextProcParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TextProcParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TextProcParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TextProcParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TextProcParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(TextProcParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link TextProcParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(TextProcParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OutpuExpr}
	 * labeled alternative in {@link TextProcParser#output}.
	 * @param ctx the parse tree
	 */
	void enterOutpuExpr(TextProcParser.OutpuExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OutpuExpr}
	 * labeled alternative in {@link TextProcParser#output}.
	 * @param ctx the parse tree
	 */
	void exitOutpuExpr(TextProcParser.OutpuExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StoreExpr}
	 * labeled alternative in {@link TextProcParser#store}.
	 * @param ctx the parse tree
	 */
	void enterStoreExpr(TextProcParser.StoreExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StoreExpr}
	 * labeled alternative in {@link TextProcParser#store}.
	 * @param ctx the parse tree
	 */
	void exitStoreExpr(TextProcParser.StoreExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprString}
	 * labeled alternative in {@link TextProcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprString(TextProcParser.ExprStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprString}
	 * labeled alternative in {@link TextProcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprString(TextProcParser.ExprStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link TextProcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(TextProcParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link TextProcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(TextProcParser.ExprIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprDollarID}
	 * labeled alternative in {@link TextProcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprDollarID(TextProcParser.ExprDollarIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprDollarID}
	 * labeled alternative in {@link TextProcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprDollarID(TextProcParser.ExprDollarIDContext ctx);
}