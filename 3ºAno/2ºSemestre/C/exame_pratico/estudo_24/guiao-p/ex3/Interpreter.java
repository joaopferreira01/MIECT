import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Interpreter extends TextProcBaseVisitor<String> {

   HashMap<String, String> map = new HashMap<>();

   @Override public String visitProgram(TextProcParser.ProgramContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitStat(TextProcParser.StatContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitOutpuExpr(TextProcParser.OutpuExprContext ctx) {
      String res = visit(ctx.expr());
      if(res != null){
         System.out.println(res);
      }
      return null;
   }

   @Override public String visitStoreExpr(TextProcParser.StoreExprContext ctx) {
      String key = ctx.ID().getText();
      String value = visit(ctx.expr());
      map.put(key,value);
      return null;
   }

   @Override public String visitExprString(TextProcParser.ExprStringContext ctx) {
      return ctx.String().getText();
   }

   @Override public String visitExprID(TextProcParser.ExprIDContext ctx) {
      return ctx.ID().getText();
   }

   @Override public String visitExprDollarID(TextProcParser.ExprDollarIDContext ctx) {
      String key = ctx.ID().getText();
      if(!map.containsKey(key)){
         System.out.println("Variable " + key + " does not exist!");
         return null;
      }
      return map.get(key);
   }
}
