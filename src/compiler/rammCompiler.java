import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

public class rammCompiler{
	public static void main(String[] args) throws Exception {
		String filename = args[0];
		rammLexer lexer = new rammLexer(new ANTLRFileStream(args[0]));
		rammParser parser = new rammParser(new CommonTokenStream(lexer));

		ParseTree tree = parser.block();
		ParseTreeWalker walker = new ParseTreeWalker();

		filename = filename.substring(0,filename.length()-5);
    	rammWalker walkk = new rammWalker(filename);
    	walker.walk( walkk, tree );

	}
}