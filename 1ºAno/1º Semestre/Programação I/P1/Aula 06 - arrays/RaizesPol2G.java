/*
 * JAM, 12-nov-2020
 * Cálculo do nº de raízes reais de um polinómio de 2º grau. Ax^2 + Bx + C = 0
 * cálculo das raízes - Arrays como parâmetros de entrada e saída
 */
import java.util.Scanner;

public class RaizesPol2G {

    public static void main(String[] args) {
        // Scanner para leitura de dados do teclado
        Scanner ler = new Scanner(System.in);
        // variáveis
        double A1, B1, C1, Xi, Xf; // coeficientes do polinómio
        int pontos = 2;
        double raiz[] = new double[2];
        int nr, mais;
        // Pode repetir o cáculo várias vezes
        do {
	    // Ler coeficientes A; B; C e intervalo de x
            System.out.println("Introduza os coeficientes A, B, C do polinomio do 2grau:");
            do {
                A1 = ler.nextDouble();
                if (A1 == 0) {
                    System.out.println("A não pode ser 0, repita:");
                }
            } while (A1 == 0);
            B1 = ler.nextDouble();
            C1 = ler.nextDouble();
            System.out.println("Introduza o intervalo Xinicial e Xfinal e o num de pontos:");
            Xi = ler.nextDouble();
            Xf = ler.nextDouble();
	    pontos = ler.nextInt();
	    
	    // Determinação das raízes
            RaizesPol2(A1, B1, C1, Xi, Xf, pontos);
          
            
	    System.out.print("Para continuar (1) fim (0):");
            mais = ler.nextInt();
        } while (mais == 1);
    }

    // função para cálculo das raízes de um polinómio do 2
    // A função devolve o nº de raizes encontradas e no parâmetro r[] as raizes

    public static void RaizesPol2(double A, double B, double C, double xi, double xf, 
				 int npontos) {
        double r[] = new double[2];
	int  nraizes = 0;
        double x, y, y0, delta;

	delta = (xf - xi)/(npontos -1);
        x = xi;
        y0 = A * x * x + B * x + C;
        for (int i = 0; i < npontos; i++) {
            x = x + delta;
            y = A * x * x + B * x + C;
            if ((y0 > 0 && y <= 0) || (y0 < 0 && y >= 0)) {
                r[nraizes] = x;
                nraizes = nraizes + 1;
            }
            y0 = y;
        }
	// escreve resultado no ecrã
	System.out.printf("Encontradas %d raizes:%n",nraizes);
	for (int i = 0; i < nraizes; i++)System.out.printf("Raiz %d = %f%n",i+1,r[i]);

    }
}
