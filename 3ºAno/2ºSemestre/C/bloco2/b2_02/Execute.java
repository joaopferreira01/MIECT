@SuppressWarnings("CheckReturnValue")
public class Execute extends SuffixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(SuffixCalculatorParser.ProgramContext ctx) {
      Double res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
      if (ctx.expr() != null) {
         Double result = visit(ctx.expr());
         System.out.println(result == null ? "ERROR" : result);
      }
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {
      Double res = null;
      return Double.parseDouble(ctx.Number().getText());
   }

   @Override public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {
      Double n1 = visit(ctx.expr(0));
      Double n2 = visit(ctx.expr(1));

      
      switch (ctx.op.getText()) {
         case "*":
            return n1 * n2;
         case "/":
            return n2 == 0 ? null : n1 / n2;
         case "+":
            return n1 + n2;
         case "-":
            return n1 - n2;
         default:
            return null;
      }

   }
}
