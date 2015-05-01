import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

/**
 * Ramm Compiler class is required to compile the code invoking the main(String[] args) function. It takes tokens as input and generates the tree. It also calls the walker class that finally generates the intermediate code. 
 * @author Aditya Narasimhamurthy
 * @author Manit Singh Kalsi
 * @author Mohit Kumar
 * @author Richa Mittal
 */

public class rammCompiler{
	public static void main(String[] args) throws Exception {

		rammLexer lexer = new rammLexer(new ANTLRFileStream(args[0]));
		rammParser parser = new rammParser(new CommonTokenStream(lexer));

		ParseTree tree = parser.block();
		ParseTreeWalker walker = new ParseTreeWalker();

		walker.walk(new rammWalker(), tree);

	}
}