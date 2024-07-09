// Generated from TextProc.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TextProcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TextProcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TextProcParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TextProcParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TextProcParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(TextProcParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OutpuExpr}
	 * labeled alternative in {@link TextProcParser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutpuExpr(TextProcParser.OutpuExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StoreExpr}
	 * labeled alternative in {@link TextProcParser#store}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStoreExpr(TextProcParser.StoreExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprString}
	 * labeled alternative in {@link TextProcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprString(TextProcParser.ExprStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link TextProcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprID(TextProcParser.ExprIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDollarID}
	 * labeled alternative in {@link TextProcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDollarID(TextProcParser.ExprDollarIDContext ctx);
}