// Generated from CalFrac.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalFracParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalFracVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalFracParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(CalFracParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalFracParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(CalFracParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalFracParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(CalFracParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalFracParser#defVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefVar(CalFracParser.DefVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SumSub}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumSub(CalFracParser.SumSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Input}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(CalFracParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParent(CalFracParser.ParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrdDiv}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrdDiv(CalFracParser.PrdDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(CalFracParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Reduce}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReduce(CalFracParser.ReduceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(CalFracParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Frac}
	 * labeled alternative in {@link CalFracParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrac(CalFracParser.FracContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalFracParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(CalFracParser.NumContext ctx);
}