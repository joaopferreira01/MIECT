// Generated from csv.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link csvParser}.
 */
public interface csvListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link csvParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(csvParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link csvParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(csvParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link csvParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(csvParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link csvParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(csvParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link csvParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(csvParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link csvParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(csvParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link csvParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(csvParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link csvParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(csvParser.FieldContext ctx);
}