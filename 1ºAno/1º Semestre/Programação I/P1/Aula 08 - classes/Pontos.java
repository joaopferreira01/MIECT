/* Aula 8 - Classes
 * JAM, 26-nov-2020
 */
import java.util.Scanner;

public class Pontos {
 
    public static void main (String args[]) {
        Ponto p1, p2;
        p1 = new Ponto();
        p2 = new Ponto();
        p1 = lerPonto();
        p2 = lerPonto();
        double dist = distancia(p1, p2);
        System.out.printf("Dist = %f\n", dist);
	System.out.println(p1.x);
    }
    
    public static Ponto lerPonto() {
	Scanner sc = new Scanner(System.in);
        Ponto p = new Ponto();
        System.out.print("x: ");
        p.x = sc.nextDouble();
        System.out.print("y: ");
        p.y = sc.nextDouble();
        return p;
    }
    
    public static double distancia(Ponto a, Ponto b){
        double d;
        d = Math.sqrt(Math.pow(b.x-a.x, 2) + Math.pow(b.y-a.y, 2));
	a.x = 10000;
        return d;
    }

}

class Ponto {
    double x;
    double y;
}

