/*
 * JAM,  29-out-2020
 * Cálculo das raízes reais de um polinómio de 2º grau. Ax^2 + Bx + C = 0
 * Procura pontos da curva em que y = 0
 */
import java.util.Scanner;

public class PolinomioRaizes {

    public static void main(String[] args) {
        // Scanner para leitura de dados do teclado
        Scanner ler = new Scanner(System.in);
        // variáveis
        double A, B, C;     // coeficientes do polinómio
        double y, y0, x;
        double delta = 0.1;// incremento entre amostras
        int nPontos = 100;  // nº de pontos a calcular
        char raiz;
        // Ler coeficientes A; B; C
        System.out.print("Introduza os coeficientes A, B, C do polinomio do 2grau:");
        A = ler.nextDouble();
        B = ler.nextDouble();
        C = ler.nextDouble();
        // Cálculo 2 raizes reais. Raiz corresponde à mudança de sinal ...
        // Começa em x= -3 e calcula nPontos pontos
        x = -3.0;
        y0 = A * x * x + B * x + C;
        for (int i = 0; i < nPontos; i++) {
            x = x + delta;
            y = A * x * x + B * x + C;
            raiz = ' ';
            if ((y0 > 0 && y <= 0) || (y0 < 0 && y >= 0)) {
                raiz = 'R';
                // imprime resultado
	    //~ }
                System.out.printf("x, y = % f, % f %c\n", x, y, raiz);
            }
            y0 = y;
        }
    }
}
