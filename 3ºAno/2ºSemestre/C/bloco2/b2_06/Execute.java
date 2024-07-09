import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("CheckReturnValue")
public class Execute extends CalculatorBaseVisitor<Double> {

   protected Map<String, Double> map = new HashMap<>();

   @Override public Double visitProgram(CalculatorParser.ProgramContext ctx) {
      Double res = null;
      return visitChildren(ctx);
      //return res;
   }
   // pq é q visit(ctx.expr() funciona para os dois e expr.assignment não)
   @Override public Double visitStat(CalculatorParser.StatContext ctx) {
      if(ctx.expr() != null){
         Double result = visit(ctx.expr());
         System.out.println(result == null ? "ERROR" : result);
      }
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitAssignment(CalculatorParser.AssignmentContext ctx) {
      String var = ctx.ID().getText();
      Double value = visit(ctx.expr());

      map.put(var, value);
      System.out.println(var+"= "+value);

      return visitChildren(ctx);
   }

   @Override public Double visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Double n1 = visit(ctx.expr(0));
      Double n2 = visit(ctx.expr(1));

      switch (ctx.op.getText()) {
         case "+":
            return n1 + n2;
         case "-":
            return n1 - n2;
         default:
            return null;
      }
   }

   @Override public Double visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Double.parseDouble(ctx.Integer().getText());
      //return res;
   }

   @Override public Double visitExprID(CalculatorParser.ExprIDContext ctx) {
      String key = ctx.ID().getText();
      if(map.containsKey(key)){
         return map.get(key);
      }
      System.out.println("Variable " + key + " does not exist!");
		return null;
   }

   @Override public Double visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      Double n1 = visit(ctx.expr(0));
      Double n2 = visit(ctx.expr(1));

      switch (ctx.op.getText()) {
         case "*":
            return n1 * n2;
         case "/":
            return n1 / n2;
         default:
            return null;
      }
      //return res;
   }
}
