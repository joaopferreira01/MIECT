/* Programação I - Funções
 * JAM, 5-nov-2020
 * calcular factorial de n; n!
 */
import java.util.Scanner;

public class FFactorial {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int n;
        System.out.print("Factorial de : ");
        n = ler.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.printf(" %3d! = %d %n",i,factorial(i));
        }
    }
    /* funcao factorial
     * devolve -1 se houver ERRO
     */
    public static int factorial(int n) {
        int fact = 1, fn1 = 2;
        for (int i = 1; i <= n; i++) {
            fn1 = fact;
            fact = fact * i;
        }
        return fact/n == fn1 ? fact:-1;
    }
}

