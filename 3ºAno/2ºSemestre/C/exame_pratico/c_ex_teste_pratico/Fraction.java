public class Fraction {
   public Fraction() {
      this.num = 0;
      this.den = 1;
   }

   public Fraction(int num, int den) {
      assert den >= 0;

      this.num = num;
      this.den = den;
   }

   public Fraction(Fraction f) {
      assert f != null;

      int d = mdc(f.num(),f.den());
      this.num = f.num()/d;
      this.den = f.den()/d;
   }

   protected int mdc(int a, int b) {
      int res = a;
      if (b != 0)
         res = mdc(b, a % b);
      return res;
   }

   public int num() {
      return num;
   }

   public int den() {
      return den;
   }

   // this = f1 + f2
   public Fraction add(Fraction f1, Fraction f2) {
      assert f1 != null;
      assert f2 != null;

      num = f1.num()*f2.den() + f2.num()*f1.den();
      den = f1.den()*f2.den();

      return this;
   }

   // this = f1 - f2
   public Fraction sub(Fraction f1, Fraction f2) {
      assert f1 != null;
      assert f2 != null;

      num = f1.num()*f2.den() - f2.num()*f1.den();
      den = f1.den()*f2.den();

      return this;
   }

   // this = f1 * f2
   public Fraction mult(Fraction f1, Fraction f2) {
      assert f1 != null;
      assert f2 != null;

      num = f1.num()*f2.num();
      den = f1.den()*f2.den();

      return this;
   }

   // this = f1 / f2
   public Fraction div(Fraction f1, Fraction f2) {
      assert f1 != null;
      assert f2 != null;

      num = f1.num()*f2.den();
      den = f1.den()*f2.num();
      if (den < 0) {
         num *= -1;
         den *= -1;
      }

      return this;
   }

   @Override public String toString() {
      return ""+num+(num != 0 && den != 1 ? "/"+den : "");
   }

   protected int num,den;
}
