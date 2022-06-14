/* Programação I - arrays
 * JAM, 12-nov-2020
 * a)-Ler notas de 0 a 20 (terminar com valor negativo), calcular media e notas > media
 * b)-Ler notas de vários testes - array 2 dimensões
 */
import java.util.Scanner;

public class Notas1b {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
	
	double[][] turma = new double[10][2];
        
	int  num = -1;
        double nota = 0, media, soma = 0;
        System.out.println("Introduza as notas dos alunos (<0 termina):");

        do {
            num++;
            System.out.printf("Introduza 2 Notas do aluno %3d: ",num+1);
	    nota = ler.nextDouble();
	    turma[num][0] = nota;
            turma[num][1] = ler.nextDouble(); 	    
        } while (nota >= 0 && num < turma.length-1);
        

	for (int i = 0; i < turma.length; i++)
	    System.out.printf("Aluno %d = %4.1f %4.1f%n", i, turma[i][0], turma[i][1]);
    }
}
