import java.util.List.*;
import java.util.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class rammWalker extends rammBaseListener {

	public StringBuilder sb = new StringBuilder();

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
