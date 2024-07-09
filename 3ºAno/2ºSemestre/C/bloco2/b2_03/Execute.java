@SuppressWarnings("CheckReturnValue")
public class Execute extends CalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(CalculatorParser.ProgramContext ctx) {
      Double res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitStat(CalculatorParser.StatContext ctx) {
      if (ctx.expr() != null) {
         Double result = visit(ctx.expr());
         System.out.println(result == null ? "ERROR" : result);
      }
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Double n1 = visit(ctx.expr(0));
      Double n2 = visit(ctx.expr(1));
      if(n1 == null || n2 == null){
         return null;
      }

      if(ctx.op.getText().equals("+")){
         return n1+n2;
      }else if(ctx.op.getText().equals("-")){
         return n1-n2;
      }
      return null;
   }

   @Override public Double visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Double visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Double.parseDouble(ctx.Integer().getText());
   }

   @Override public Double visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      Double n1 = visit(ctx.expr(0));
      Double n2 = visit(ctx.expr(1));
      if(n1 == null || n2 == null){
         return null;
      }

      if(ctx.op.getText().equals("*")){
         return n1*n2;
      }else if(ctx.op.getText().equals("/")){
         return n1/n2;
      }
      return null;
   }
}
