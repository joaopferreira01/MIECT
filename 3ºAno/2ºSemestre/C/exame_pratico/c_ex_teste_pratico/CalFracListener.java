// Generated from CalFrac.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalFracParser}.
 */
public interface CalFracListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalFracParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(CalFracParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalFracParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(CalFracParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalFracParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(CalFracParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalFracParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(CalFracParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalFracParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(CalFracParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalFracParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(CalFracParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalFracParser#defVar}.
	 * @param ctx the parse tree
	 */
	void enterDefVar(CalFracParser.DefVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalFracParser#defVar}.
	 * @param ctx the parse tree
	 */
	void exitDefVar(CalFracParser.DefVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SumSub}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSumSub(CalFracParser.SumSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SumSub}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSumSub(CalFracParser.SumSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Input}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInput(CalFracParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Input}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInput(CalFracParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParent(CalFracParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParent(CalFracParser.ParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrdDiv}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrdDiv(CalFracParser.PrdDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrdDiv}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrdDiv(CalFracParser.PrdDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(CalFracParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(CalFracParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Reduce}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterReduce(CalFracParser.ReduceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Reduce}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitReduce(CalFracParser.ReduceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Power}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPower(CalFracParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPower(CalFracParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Frac}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFrac(CalFracParser.FracContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Frac}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFrac(CalFracParser.FracContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalFracParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(CalFracParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalFracParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(CalFracParser.NumContext ctx);
}