// Generated from Hello.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#more}.
	 * @param ctx the parse tree
	 */
	void enterMore(HelloParser.MoreContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#more}.
	 * @param ctx the parse tree
	 */
	void exitMore(HelloParser.MoreContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#any}.
	 * @param ctx the parse tree
	 */
	void enterAny(HelloParser.AnyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#any}.
	 * @param ctx the parse tree
	 */
	void exitAny(HelloParser.AnyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#greetings}.
	 * @param ctx the parse tree
	 */
	void enterGreetings(HelloParser.GreetingsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#greetings}.
	 * @param ctx the parse tree
	 */
	void exitGreetings(HelloParser.GreetingsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#bye}.
	 * @param ctx the parse tree
	 */
	void enterBye(HelloParser.ByeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#bye}.
	 * @param ctx the parse tree
	 */
	void exitBye(HelloParser.ByeContext ctx);
}