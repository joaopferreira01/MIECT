import java.util.Iterator;

@SuppressWarnings("CheckReturnValue")
public class Execute extends CalculatorBaseVisitor<String> {

   @Override
   public String visitProgram(CalculatorParser.ProgramContext ctx) {
      String res = "";
      Iterator<CalculatorParser.StatContext> iter = ctx.stat().iterator();
      while (iter.hasNext())
         res += visit(iter.next()) + "\n";
      System.out.println(res);
      return res;

      // return res;
   }

   @Override
   public String visitStatExpr(CalculatorParser.StatExprContext ctx) {
      return visit(ctx.expr());
      // return res;
   }

   @Override
   public String visitStatAssign(CalculatorParser.StatAssignContext ctx) {
      return visit(ctx.assignment());
   }

   @Override
   public String visitAssignment(CalculatorParser.AssignmentContext ctx) {
      String res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public String visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      return visit(ctx.expr(0)) + " " + visit(ctx.expr(1)) + " " + ctx.op.getText();
   }

   @Override
   public String visitExprParent(CalculatorParser.ExprParentContext ctx) {
      String res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public String visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return ctx.Integer().getText();
      // return res;
   }

   @Override
   public String visitExprID(CalculatorParser.ExprIDContext ctx) {
      String res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public String visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      return visit(ctx.expr(0)) + " " + visit(ctx.expr(1)) + " " + ctx.op.getText();
      // return res;
   }
}
