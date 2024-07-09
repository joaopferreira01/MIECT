/*
 * JAM, 29-out-2020
 * calcular factorial de n
 */
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        long n, fact;

        System.out.print("Factorial de : ");
        n = ler.nextInt();
	
        // calcular n! = 1 * 2 * 3 * ...* n
        fact = 1;
        for (int i = 1; i<= n; i++) {
            fact = fact * i;
            //~ System.out.printf(" %3d! = % d %n",n,fact);
        }
        System.out.printf(" %3d! = % d %n",n,fact);
    }
}

