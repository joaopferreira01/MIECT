import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings("CheckReturnValue")
public class NDInterpreter extends StrLangBaseVisitor<String> {

   private Map<String, String> map = new HashMap<>();
   Scanner scanner = new Scanner(System.in);

   @Override
   public String visitMain(StrLangParser.MainContext ctx) {
      String res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public String visitStatPrint(StrLangParser.StatPrintContext ctx) {
      String res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public String visitStatAssignment(StrLangParser.StatAssignmentContext ctx) {
      String res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public String visitPrintExpr(StrLangParser.PrintExprContext ctx) {
      String res = visit(ctx.expr());
      if (res != null) {
         System.out.println(res);
      }
      return null;
      // return res;
   }

   @Override
   public String visitAssignmentExpr(StrLangParser.AssignmentExprContext ctx) {
      String key = ctx.ID().getText();
      map.put(key, visit(ctx.expr()));
      return null;
   }

   @Override
   public String visitAssignmentTerminal(StrLangParser.AssignmentTerminalContext ctx) {
      String key = ctx.ID().getText();
      System.out.println(visit(ctx.expr()));
      String input = scanner.nextLine();
      map.put(key, input);
      return null;
   }

   @Override
   public String visitExprReplace(StrLangParser.ExprReplaceContext ctx) {
      String value = visit(ctx.expr(0));
      String tirar = visit(ctx.expr(1));
      String meter = visit(ctx.expr(2));

      return value.replaceAll(tirar, meter);
   }

   @Override
   public String visitExprString(StrLangParser.ExprStringContext ctx) {
      String string = ctx.String().getText();
      return string.substring(1, string.length()-1);
   }

   @Override
   public String visitExprParent(StrLangParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override
   public String visitExprSub(StrLangParser.ExprSubContext ctx) {
      String value = visit(ctx.expr(0));
      String tirar = visit(ctx.expr(1));

      return value.replaceAll(tirar, "");
   }

   @Override
   public String visitExprTrim(StrLangParser.ExprTrimContext ctx) {
      return visit(ctx.expr());
   }

   @Override
   public String visitExprID(StrLangParser.ExprIDContext ctx) {
      String key = ctx.ID().getText();
      if (map.containsKey(key)) {
         return map.get(key);
      }
      System.out.println("Variable does not exist");
      return null;
   }

   @Override
   public String visitExprAdd(StrLangParser.ExprAddContext ctx) {
      return visit(ctx.expr(0)) + visit(ctx.expr(1));
   }
}
