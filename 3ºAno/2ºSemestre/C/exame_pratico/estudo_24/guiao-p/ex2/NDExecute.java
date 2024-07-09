import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class NDExecute extends FracLangBaseVisitor<Fraction> {

   HashMap<String, Fraction> map = new HashMap<>();

   @Override
   public Fraction visitProgram(FracLangParser.ProgramContext ctx) {
      Fraction res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public Fraction visitStatAssig(FracLangParser.StatAssigContext ctx) {
      Fraction res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public Fraction visitStatDisplay(FracLangParser.StatDisplayContext ctx) {
      Fraction res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public Fraction visitDisplay(FracLangParser.DisplayContext ctx) {
      Fraction f = visit(ctx.expr());
      if (f != null) {
         System.out.println(f);
      }
      return null;
   }

   @Override
   public Fraction visitAssig(FracLangParser.AssigContext ctx) {
      String key = ctx.ID().getText();
      map.put(key, visit(ctx.expr()));

      return null;
   }

   @Override
   public Fraction visitExprAddSub(FracLangParser.ExprAddSubContext ctx) {
      String op = ctx.op.getText();

      if (op.equals("+"))
         return visit(ctx.expr(0)).addTo((visit(ctx.expr(1))));
      if (op.equals("-"))
         return visit(ctx.expr(0)).subTo((visit(ctx.expr(1))));

      return null;
   }

   @Override
   public Fraction visitExprParent(FracLangParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override
   public Fraction visitExprNumber(FracLangParser.ExprNumberContext ctx) {
      return new Fraction(Integer.parseInt(ctx.Number().getText()));

   }

   @Override
   public Fraction visitExprMultDiv(FracLangParser.ExprMultDivContext ctx) {
      String op = ctx.op.getText();

      if (op.equals("*"))
         return visit(ctx.expr(0)).multTo((visit(ctx.expr(1))));
      if (op.equals(":"))
         return visit(ctx.expr(0)).divTo((visit(ctx.expr(1))));

      return null;
   }

   @Override
   public Fraction visitExprPlusMinus(FracLangParser.ExprPlusMinusContext ctx) {
      if (ctx.op.getText().equals("-"))
         return visit(ctx.expr()).negFrac();

      return visit(ctx.expr());
   }

   @Override
   public Fraction visitExprID(FracLangParser.ExprIDContext ctx) {
      String key = ctx.ID().getText();
      if (!map.containsKey(key)) {
         System.out.println("Variable " + key + " does not exist!");
      }
      return map.get(key);
   }

   @Override
   public Fraction visitExprFraction(FracLangParser.ExprFractionContext ctx) {
      return new Fraction(Integer.parseInt(ctx.Number(0).getText()), Integer.parseInt(ctx.Number(1).getText()));
   }
}
