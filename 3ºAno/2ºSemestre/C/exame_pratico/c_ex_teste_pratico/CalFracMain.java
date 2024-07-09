import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class CalFracMain {
   public static void main(String[] args) throws Exception {
      for(String f: args) {
         try {
            CharStream input = CharStreams.fromStream(new FileInputStream(f));
            // create a lexer that feeds off of input CharStream:
            CalFracLexer lexer = new CalFracLexer(input);
            // create a buffer of tokens pulled from the lexer:
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            // create a parser that feeds off the tokens buffer:
            CalFracParser parser = new CalFracParser(tokens);
            // replace error listener:
            //parser.removeErrorListeners(); // remove ConsoleErrorListener
            //parser.addErrorListener(new ErrorHandlingListener());
            // begin parsing at main rule:
            ParseTree tree = parser.main();
            if (parser.getNumberOfSyntaxErrors() == 0) {
               // print LISP-style tree:
               // System.out.println(tree.toStringTree(parser));
               Execute visitor0 = new Execute();
               visitor0.visit(tree);
            }
         }
         catch(FileNotFoundException e) {
            System.err.println("ERROR: file \""+f+"\" not found!");
         }
      }
   }
}
