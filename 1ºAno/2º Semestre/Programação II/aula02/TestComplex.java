import static java.lang.System.*;
import java.util.Scanner;

public class TestComplex {
  // Exemplo simples de utilização da class Complex
  public static final Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) {
    double b, c;
    if(args.length == 0){
      System.out.println("Re: ");
      b = scanner.nextDouble();
      System.out.println("Im: ");
      c = scanner.nextDouble();
    }else{
      if(args.length >= 1){
        b = Double.parseDouble(args[0]);
      }else{
        b = 0;
      }if(args.length >= 2){
        c = Double.parseDouble(args[1]);
      }else{
        c = 0;
      }
    }
    
    Complex a = new Complex(b, c);

    // Vamos usar métodos do objeto a
    out.printf("(%.2f+%.2fi)\n", a.real(), a.imag());
    out.println("  parte real = " + a.real());
    out.println("  parte imaginaria = " + a.imag());
    out.println("  modulo = " + a.abs());
    out.printf("  argumento = %.2f\n", a.arg());
  }

}
