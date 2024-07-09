import static java.lang.System.*;
import java.util.*;

public class Execute extends CalFracBaseVisitor<Fraction> {
	
	@Override public Fraction visitPrint(CalFracParser.PrintContext ctx) {
      Fraction res = visit(ctx.expr());
      if (res != null)
         out.println(res);
      return res;
   }

	@Override public Fraction visitDefVar(CalFracParser.DefVarContext ctx) {
      Fraction res = visit(ctx.expr());
      String var = ctx.VAR().getText();
      if (res != null)

         symbolTable.put(var, res);
      return res;
   }
	
	@Override public Fraction visitSumSub(CalFracParser.SumSubContext ctx) {
      Fraction res = null;
      Fraction f1 = visit(ctx.expr(0));
      Fraction f2 = visit(ctx.expr(1));
      if (f1 != null && f2 != null)
         res = "+".equals(ctx.op.getText()) ? new Fraction().add(f1,f2) : new Fraction().sub(f1,f2);
      return res;
   }
	
	@Override public Fraction visitPrdDiv(CalFracParser.PrdDivContext ctx) {
      Fraction res = null;
      Fraction f1 = visit(ctx.expr(0));
      Fraction f2 = visit(ctx.expr(1));
      if (f1 != null && f2 != null)
         res = "*".equals(ctx.op.getText()) ? new Fraction().mult(f1,f2) : new Fraction().div(f1,f2);
      return res;
   }
	
	@Override public Fraction visitPower(CalFracParser.PowerContext ctx) {
      Fraction res = null;
      Fraction base = visit(ctx.expr());
      if (base != null) {
         int exp = Integer.parseInt(ctx.num().getText());
         if (exp < 0)
            res = new Fraction((int)Math.pow(base.den(),-exp), (int)Math.pow(base.num(),-exp));
         else
            res = new Fraction((int)Math.pow(base.num(),exp), (int)Math.pow(base.den(),exp));
      }
      return res;
   }
	
	@Override public Fraction visitParent(CalFracParser.ParentContext ctx) {
      return visit(ctx.expr());
   }
	
	@Override public Fraction visitVarExpr(CalFracParser.VarExprContext ctx) {
      Fraction res = null;
      String var = ctx.VAR().getText();
      if (symbolTable.containsKey(var))
         res = symbolTable.get(var);
      else
         err.println("ERROR: variable "+var+" not defined!");
      return res;
   }
	
	@Override public Fraction visitFrac(CalFracParser.FracContext ctx) {
      return new Fraction(Integer.parseInt(ctx.n.getText()), ctx.d != null ? Integer.parseInt(ctx.d.getText()): 1);
   }
	
	@Override public Fraction visitInput(CalFracParser.InputContext ctx) {
      Fraction res = null;
      String prompt = ctx.STRING().getText();
      out.print(prompt.substring(1,prompt.length()-1)+": ");
      String inp = scin.nextLine();
      String[] part = inp.split("/");
      if (part.length < 1 || part.length > 2) {
         err.println("ERROR: invalid input!");
      }
      else {
         try {
            int num = Integer.parseInt(part[0]);
            int den = part.length == 2 ? Integer.parseInt(part[1]) : 1;
            res = new Fraction(num,den);
         }
         catch(NumberFormatException e) {
            err.println("ERROR: invalid input!");
         }
      }
      return res;
   }
	
	@Override public Fraction visitReduce(CalFracParser.ReduceContext ctx) {
      Fraction res = null;
      Fraction f = visit(ctx.expr());
      if (f != null)
         res = new Fraction(f);
      return res;
   }
	
   /*
	@Override public Fraction visitNum(CalFracParser.NumContext ctx) {
      Fraction res = Long.parseLong(ctx->NUM().getText());
      if ("-".equals(ctx.op.getText()))
         res = new Fraction(-res.num(), res.den());
      return res;
   }
   */

   private Map<String,Fraction> symbolTable = new HashMap<>();
   static final Scanner scin = new Scanner(System.in);

}
