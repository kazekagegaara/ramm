import java.util.List.*;
import java.util.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class rammWalker extends rammBaseListener {

	public StringBuilder sb = new StringBuilder();


	public void enterBlock(rammParser.BlockContext ctx) {}

	public void exitBlock(rammParser.BlockContext ctx) {

		String str = sb.toString();
		try {
			PrintWriter writer = new PrintWriter("intermediate.rammc", "UTF-8");
			writer.println(sb);
			writer.close();
		} catch (FileNotFoundException f) {
			System.out.println(f);

		} catch (UnsupportedEncodingException u) {
			System.out.println(u);

		}
	}

	public void enterFunctionDecl(rammParser.FunctionDeclContext ctx) {

		sb.append("PROC ");
		sb.append(ctx.Identifier().getText().toLowerCase() + " ");

	}


	public void exitFunctionDecl(rammParser.FunctionDeclContext ctx) {
		sb.append("}\r\n");

	}

	public void enterIdentifierFunctionCall(rammParser.IdentifierFunctionCallContext ctx) {

		sb.append("LOAD ");
		sb.append(ctx.Identifier().getText().toLowerCase() + " ");

	}

	public void enterStatement(rammParser.StatementContext ctx) {

	}

	public void enterAssignment(rammParser.AssignmentContext ctx) {

		sb.append("SET ");
		sb.append(ctx.Identifier().getText().toLowerCase() + " ");
	}

	public void enterPrintlnFunctionCall(rammParser.PrintlnFunctionCallContext ctx) {

	sb.append("PRINTLN ");		
	}

	public void enterPrintFunctionCall(rammParser.PrintFunctionCallContext ctx) {

		sb.append("PRINT ");
	}

	public void enterAssertFunctionCall(rammParser.AssertFunctionCallContext ctx) {}

	public void enterSizeFunctionCall(rammParser.SizeFunctionCallContext ctx) {}

	public void enterIdList(rammParser.IdListContext ctx) {
		

		if (ctx.Identifier().size() > 1) {

			Iterator < TerminalNode > itr = ctx.Identifier().iterator();
			String prefix = "";
			while (itr.hasNext()) {
				sb.append(prefix);
				prefix = ",";
				sb.append(itr.next().getText().toLowerCase());
			}
		} else if (ctx.Identifier().size() == 1) {
			sb.append(ctx.Identifier(0).getText().toLowerCase() + " ");

		}

	}

	public void exitIdList(rammParser.IdListContext ctx) {

		sb.append("\r\n{\r\n");

	}

	public void enterGtExpression(rammParser.GtExpressionContext ctx) {

		sb.append("GT ");
		Iterator < rammParser.ExpressionContext > itr = ctx.expression().iterator();

	}

	public void enterLtExpression(rammParser.LtExpressionContext ctx) {

		sb.append("LT ");

	}

	public void enterIfStatement(rammParser.IfStatementContext ctx) {

	}

	public void exitIfStatement(rammParser.IfStatementContext ctx) {
		sb.append("}\r\n");

	}

	public void enterIfStat(rammParser.IfStatContext ctx) {
		sb.append("\r\nCHECK ");

	}

	public void enterElseIfStat(rammParser.ElseIfStatContext ctx) {}

	public void enterElseStat(rammParser.ElseStatContext ctx) {
		sb.append("}\r\nFALSE {\r\n");
	}



	public void enterForStatement(rammParser.ForStatementContext ctx) {}

	public void enterWhileStatement(rammParser.WhileStatementContext ctx) {

		
		sb.append("LOOP ");

	}

	public void enterIdentifierExpression(rammParser.IdentifierExpressionContext ctx) {
		
		String x = ctx.getText();
		
		String z = sb.toString();
		String[] y = z.split(" ");


		
		if (y[y.length - 1].equals("E") || y[y.length - 1].equals("NE") || y[y.length - 1].equals("GE") || y[y.length - 1].equals("LE") || y[y.length - 1].equals("GT") || y[y.length - 1].equals("LT")) {
			sb.append(ctx.getText() + ",");
		} else if (y[y.length - 1].equals("ADD") || y[y.length - 1].equals("SUB") || y[y.length - 1].equals("MUL") || y[y.length - 1].equals("DIV") || y[y.length - 1].equals("MOD")) {
			sb.append(ctx.getText() + ",");
		} else {
			sb.append(ctx.getText() + " ");
		}

	}

	public void enterReturnExpression(rammParser.ReturnExpressionContext ctx) {
		sb.append("RETURN ");
	}


	public void exitReturnExpression(rammParser.ReturnExpressionContext ctx) {}
	public void enterExprList(rammParser.ExprListContext ctx) {

	}

	public void enterDivideExpression(rammParser.DivideExpressionContext ctx) {


		sb.append("DIV ");

	}

	public void enterModulusExpression(rammParser.ModulusExpressionContext ctx) {
		sb.append("MOD ");
	}

	public void enterEqExpression(rammParser.EqExpressionContext ctx) {

		sb.append("E ");

	}

	public void enterGtEqExpression(rammParser.GtEqExpressionContext ctx) {

		sb.append("GE ");


	}

	public void enterNotEqExpression(rammParser.NotEqExpressionContext ctx) {
		sb.append("NE ");

	}

	public void enterLtEqExpression(rammParser.LtEqExpressionContext ctx) {
		sb.append("LE ");

	}

	public void enterAddExpression(rammParser.AddExpressionContext ctx) {
		sb.append("ADD ");

	}

	public void enterOrExpression(rammParser.OrExpressionContext ctx) {}

	public void enterPowerExpression(rammParser.PowerExpressionContext ctx) {}

	public void enterExpressionExpression(rammParser.ExpressionExpressionContext ctx) {

	}


	public void enterReturnExpression(rammParser.ReturnExpressionContext ctx) {
		sb.append("RETURN ");
	}


	public void exitReturnExpression(rammParser.ReturnExpressionContext ctx) {}
	public void enterExprList(rammParser.ExprListContext ctx) {

	}

	public void enterDivideExpression(rammParser.DivideExpressionContext ctx) {


		sb.append("DIV ");

	}
