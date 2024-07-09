/* Programação I - Funções
 * JAM, 5/9-nov-2020
 *
 */
import java.util.Scanner;

public class Funcoes {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n = 3;

        for (int i = 0; i < 10; i++) {
            System.out.printf(" %d x %d = %d %n", n, i, n * i);
        }
	
	tabua(8);
	int z = 2;
	tabua(z);
	System.out.println(cubo(z));
	z = 1 + cubo(n);
	z = add(1, 5);
	z = add(n, z);
	System.out.println(cubo(3.1));
    }
    // programação modular - funções
    public static void tabua (int n){
	for (int i = 0; i < 10; i++) {
		System.out.printf(" %d x %d = %d %n", n, i, n * i);
	}
    }
    public static int cubo(int x){
	if (x < 0) return -1;
	int r = x * x * x;
	return r;
    }
    public static double cubo(double x){
	if (x < 0) return -1;
	double r = x * x * x;
	return r;
    }
    public static int add(int a, int b){
	return a + b;
    }
}

