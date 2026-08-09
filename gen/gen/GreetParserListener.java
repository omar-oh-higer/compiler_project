// Generated from grammar/GreetParser.g4 by ANTLR 4.13.2
package gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GreetParser}.
 */
public interface GreetParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GreetParser#greeting}.
	 * @param ctx the parse tree
	 */
	void enterGreeting(GreetParser.GreetingContext ctx);
	/**
	 * Exit a parse tree produced by {@link GreetParser#greeting}.
	 * @param ctx the parse tree
	 */
	void exitGreeting(GreetParser.GreetingContext ctx);
}