import java.util.List.*;
import java.util.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class rammWalker extends rammBaseListener {

	public StringBuilder sb = new StringBuilder();


	public void xBlock(rammParser.BlockContext ctx) {

		Iterator < rammParser.FunctionDeclContext > itr = ctx.functionDecl().iterator();
		while (itr.hasNext()) {
			//	//System.out.println(itr.next().block());
			Iterator < rammParser.StatementContext > itr_st = itr.next().block().statement().iterator();
			while (itr_st.hasNext()) {
				//System.out.println(itr_st.next().assignment().expression().getText());
			}


			////System.out.println( "Entering block : " + ctx.statement().assignment().Identifier().getText());

		}
	}



	public void enterBlock(rammParser.BlockContext ctx) {
		
		////System.out.println("Entering block");

	}

	public void exitBlock(rammParser.BlockContext ctx) {
		
		////System.out.println("Exiting block");
		
		String str = sb.toString();
		try {
			PrintWriter writer = new PrintWriter("program.rammc", "UTF-8");
			writer.println(sb);
			writer.close();
		} catch (FileNotFoundException f) {
			//System.out.println(f);

		} catch (UnsupportedEncodingException u) {
			//System.out.println(u);

		}
	}

	public void enterFunctionDecl(rammParser.FunctionDeclContext ctx) {

		//System.out.println("Entering Function Declaration");
		sb.append("PROC ");
		sb.append(ctx.Identifier().getText().toLowerCase() + " ");

	}


	public void exitFunctionDecl(rammParser.FunctionDeclContext ctx) {
		//System.out.println("Exiting Function Declaration");
		sb.append("}\r\n");

	}

	public void enterIdentifierFunctionCall(rammParser.IdentifierFunctionCallContext ctx) { 
		//System.out.println("Entering Function call");

		sb.append("LOAD ");
		sb.append(ctx.Identifier().getText().toLowerCase()+" ");
	
	 }

	public void enterStatement(rammParser.StatementContext ctx) {
	//System.out.println("Entering statement");

	}

	public void enterIdentifierExpression(rammParser.IdentifierExpressionContext ctx) {
		System.out.println("Entering Identifier Expression");
		String x =ctx.getText();
		System.out.println("String at this point is "+sb);
		String z = sb.toString();
		String[]y = z.split(" ");
		//System.out.println("----------------"+ctx.getText());
		if(y[y.length-1].equals("E")||y[y.length-1].equals("NE")||y[y.length-1].equals("GE")||y[y.length-1].equals("LE")||y[y.length-1].equals("GT")||y[y.length-1].equals("LT"))
		{
		sb.append(ctx.getText()+" , ");
		} 
		else if(y[y.length-1].equals("DIV")||y[y.length-1].equals("MUL")||y[y.length-1].equals("ADD")||y[y.length-1].equals("SUB")||y[y.length-1].equals("MOD")){
			sb.append(ctx.getText()+" , ");
		}
	
		else{
		sb.append(ctx.getText()+" ");	
		}

	}

	public void exitIdentifierExpression(rammParser.IdentifierExpressionContext ctx)
	{
		System.out.println("Exit Identifier Expression");
	}

	public void enterNumberExpression(rammParser.NumberExpressionContext ctx)
	{
		System.out.println("Enter Number Expression");

		sb.append(ctx.getText() + " ");
			
	}

	public void exitNumberExpression(rammParser.NumberExpressionContext ctx)
	{
		System.out.println("Exit Number Expression");
	}
	
	}