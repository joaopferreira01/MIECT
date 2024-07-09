/*
 * JAM, 29-out-2020
 * Imprimir tabuada do 6
 * 6 x 0 = 0
 * 6 x 1 = 6
 * ...
 */
public class Tabuas {
    public static void main(String[] args) {
        int n=6;
	int i=0;
        System.out.printf("Tabuada do %d %n", n);

        System.out.printf(" %d x %d = %d %n", n, i, n * i++);
        System.out.printf(" %d x %d = %d %n", n, i, n * i++);
        System.out.printf(" %d x %d = %d %n", n, i, n * i++);
        System.out.printf(" %d x %d = %d %n", n, i, n * i++);
        
	for (n = 2; n < 7; n = n + 2) {
	    System.out.printf("Tabuada do %d %n", n);
            for (i = 0; i < 10; i++) {
                System.out.printf(" %d x %d = %d %n", n, i, n * i);
            }
        }
    }
}

