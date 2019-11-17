import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
public class translate {
    public String file;

    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from the input

        CSharpLexer lexer;
        if (args.length > 0)
            lexer = new CSharpLexer(CharStreams.fromFileName(args[0]));
        else
            lexer = new CSharpLexer(CharStreams.fromStream(System.in));
        // create a buffer of tokens pulled from the lexer

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer
        CSharpParser parser = new CSharpParser(tokens);
        ParseTree tree = parser.compilation_unit(); // begin parsing at init rule

        // Create a generic parse tree walker that can trigger callbacks
        ParseTreeWalker walker = new ParseTreeWalker();
        // Walk the tree created during the parse, trigger callbacks
        walker.walk(new documenter(), tree);
        System.out.println(); // print a \n after translation}

    }
}