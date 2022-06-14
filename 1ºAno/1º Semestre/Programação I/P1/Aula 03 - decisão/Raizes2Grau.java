/*
 * JAM, out-2020
 * Cálculo das raízes reais e imaginárias de um polinómio de 2º grau. Ax^2 + Bx + C = 0
 * Solução: raizes = (-B +- raizq(B² - 4AC))/2A
 */
import java.util.Scanner;

public class Raizes2Grau {

    public static void main(String[] args) {
        // Scanner para leitura de dados do teclado
        Scanner ler = new Scanner(System.in);
        // variáveis
        double a,b,c; 		// coeficientes do polin.
        double r1, r2, i1,i2; 	// raizes - r1, r2 - parte real e i1,i2 - parte imaginária
        double delta;
        // ler coeficientes do teclado
        System.out.print("Introduza os coeficientes do polinómio (a, b, c):");
        a = ler.nextDouble();
        if (a != 0) {
            b = ler.nextDouble();
            c = ler.nextDouble();
            delta = b*b-4*a*c;
            if (delta >= 0) {
                r1 = (-b+Math.sqrt(delta))/(2*a);
                r2 = (-b-Math.sqrt(delta))/(2*a);
                System.out.printf("Raizes: %f, %f\n",r1,r2);
            } else {
                r1 = -b/(2*a);
                i1 = +Math.sqrt(-delta)/(2*a);
                r2 = r1;
                i2 = -i1;
                System.out.printf("raizes imaginarias: \n%f i%f\n%f i%f\n",r1,i1,r2,i2);
            }

        } else {
            System.out.printf("a = 0, não é um polinómio do 2º grau!\n");
        }
    }
}
