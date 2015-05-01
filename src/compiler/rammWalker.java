import java.util.List.*;
import java.util.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class rammWalker extends rammBaseListener {

	public StringBuilder sb = new StringBuilder();
	String filename;
	rammWalker(String x)
	{
		this.filename = x;
	}
	public void enterBlock(rammParser.BlockContext ctx) {}

	public void exitBlock(rammParser.BlockContext ctx) {

		String str = sb.toString();
		try {
			PrintWriter writer = new PrintWriter(filename+".rammc", "UTF-8");
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

	public void enterSubtractExpression(rammParser.SubtractExpressionContext ctx) {
		sb.append("SUB ");

	}


	public void enterMultiplyExpression(rammParser.MultiplyExpressionContext ctx) {
		sb.append("MUL ");

	}


	public void exitStatement(rammParser.StatementContext ctx) {}

	public void exitAssignment(rammParser.AssignmentContext ctx) {}

	public void exitIdentifierFunctionCall(rammParser.IdentifierFunctionCallContext ctx) {}

	public void exitPrintlnFunctionCall(rammParser.PrintlnFunctionCallContext ctx) {}

	public void exitPrintFunctionCall(rammParser.PrintFunctionCallContext ctx) {}

	public void exitAssertFunctionCall(rammParser.AssertFunctionCallContext ctx) {}

	public void exitSizeFunctionCall(rammParser.SizeFunctionCallContext ctx) {}


	public void exitIfStat(rammParser.IfStatContext ctx) {}

	public void exitElseIfStat(rammParser.ElseIfStatContext ctx) {}

	public void exitElseStat(rammParser.ElseStatContext ctx) {

	}


	public void exitForStatement(rammParser.ForStatementContext ctx) {

	}

	public void exitWhileStatement(rammParser.WhileStatementContext ctx) {

		sb.append("}\r\n");
	}


	public void exitExprList(rammParser.ExprListContext ctx) {

	}

	public void exitGtExpression(rammParser.GtExpressionContext ctx) {

		sb.append("\r\nTRUE {\r\n");
	}
	public void enterNumberExpression(rammParser.NumberExpressionContext ctx) {


		sb.append(ctx.getText() + " ");

	}
	public void exitNumberExpression(rammParser.NumberExpressionContext ctx) {}

	public void exitIdentifierExpression(rammParser.IdentifierExpressionContext ctx) {}

	public void exitModulusExpression(rammParser.ModulusExpressionContext ctx) {}
	public void enterNotExpression(rammParser.NotExpressionContext ctx) {}
	public void exitNotExpression(rammParser.NotExpressionContext ctx) {}

	public void exitMultiplyExpression(rammParser.MultiplyExpressionContext ctx) {}



	public void exitGtEqExpression(rammParser.GtEqExpressionContext ctx) {
		sb.append("\r\nTRUE {\r\n");
	}
	public void enterAndExpression(rammParser.AndExpressionContext ctx) {}
	public void exitAndExpression(rammParser.AndExpressionContext ctx) {}
	public void enterStringExpression(rammParser.StringExpressionContext ctx) {
		sb.append(ctx.getText()+ " ");
	}
	public void exitStringExpression(rammParser.StringExpressionContext ctx) {}

	public void exitExpressionExpression(rammParser.ExpressionExpressionContext ctx) {}
	public void enterNullExpression(rammParser.NullExpressionContext ctx) {}
	public void exitNullExpression(rammParser.NullExpressionContext ctx) {}
	public void enterFunctionCallExpression(rammParser.FunctionCallExpressionContext ctx) {}
	public void exitFunctionCallExpression(rammParser.FunctionCallExpressionContext ctx) {}
	public void enterListExpression(rammParser.ListExpressionContext ctx) {}
	public void exitListExpression(rammParser.ListExpressionContext ctx) {}

	public void exitLtEqExpression(rammParser.LtEqExpressionContext ctx) {
		sb.append("\r\nTRUE {\r\n");
	}

	public void exitLtExpression(rammParser.LtExpressionContext ctx) {
		sb.append("\r\nTRUE {\r\n");
	}
	public void enterBoolExpression(rammParser.BoolExpressionContext ctx) {
		sb.append(ctx.getText().toUpperCase() + "\r\n");
	}
	public void exitBoolExpression(rammParser.BoolExpressionContext ctx) {}

	public void exitNotEqExpression(rammParser.NotEqExpressionContext ctx) {
		sb.append("\r\nTRUE {\r\n");
	}

	public void exitDivideExpression(rammParser.DivideExpressionContext ctx) {}

	public void exitOrExpression(rammParser.OrExpressionContext ctx) {}
	public void enterUnaryMinusExpression(rammParser.UnaryMinusExpressionContext ctx) {}
	public void exitUnaryMinusExpression(rammParser.UnaryMinusExpressionContext ctx) {

	}

	public void exitPowerExpression(rammParser.PowerExpressionContext ctx) {}


	public void exitEqExpression(rammParser.EqExpressionContext ctx) {
		sb.append("\r\nTRUE {\r\n");
	}
	public void enterInExpression(rammParser.InExpressionContext ctx) {}
	public void exitInExpression(rammParser.InExpressionContext ctx) {}

	public void exitAddExpression(rammParser.AddExpressionContext ctx) {}

	public void exitSubtractExpression(rammParser.SubtractExpressionContext ctx) {}
	public void enterTernaryExpression(rammParser.TernaryExpressionContext ctx) {}
	public void exitTernaryExpression(rammParser.TernaryExpressionContext ctx) {}
	public void enterInputExpression(rammParser.InputExpressionContext ctx) {

	}
	public void exitInputExpression(rammParser.InputExpressionContext ctx) {}
	public void enterList(rammParser.ListContext ctx) {

	}
	public void exitList(rammParser.ListContext ctx) {}

	public void enterIndexes(rammParser.IndexesContext ctx) {}

	public void exitIndexes(rammParser.IndexesContext ctx) {

	}

}