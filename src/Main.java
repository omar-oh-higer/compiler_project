import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import gen.GreetLexer;
import gen.GreetParser;

public class Main {
    public static void main(String[] args) {
        String sampleInput = "hello world";

        CharStream input = CharStreams.fromString(sampleInput);

        GreetLexer lexer = new GreetLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        GreetParser parser = new GreetParser(tokens);
        ParseTree tree = parser.greeting();

        System.out.println("Input: " + sampleInput);
        System.out.println("Parse tree: " + tree.toStringTree(parser));
    }
}
