import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

public class rammCompiler{
	public static void main(String[] args) throws Exception {

		rammLexer lexer = new rammLexer(new ANTLRFileStream(args[0]));
		rammParser parser = new rammParser(new CommonTokenStream(lexer));

		ParseTree tree = parser.block();
		ParseTreeWalker walker = new ParseTreeWalker();

		walker.walk(new rammWalker(), tree);

	}
}