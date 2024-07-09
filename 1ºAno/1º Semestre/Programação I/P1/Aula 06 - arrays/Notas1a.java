/* Programação I - arrays
 * JAM, 12-nov-2020
 * a)-Ler notas de 0 a 20 (terminar com valor negativo), calcular media e notas > media
 * b)-Ler notas de vários testes
 */
import java.util.Scanner;

public class Notas1a {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
	
	double[] notas = new double[10]; //definição array notas
	double[] v;
	v = notas;
	
	//~ double notas[] = {11.1, 12, 8.9};
        
	int  num = -1;
        double nota = 0, media, soma = 0;
        System.out.println("Introduza as notas dos alunos (<0 termina):");

        do {
            soma = soma + nota;
            num++;
            System.out.printf("Nota aluno %3d: ",num+1);
            nota = ler.nextDouble();
	    notas[num] = nota;
        } while (nota >= 0 && num < notas.length-1);
        
        media = soma/num;
        System.out.printf("Soma  = %4.1f\nMedia = %4.1f\n",soma,media);
	for (int i = 0; i < notas.length; i++)System.out.printf("Nota %d = %4.1f%n", i, notas[i]);
	System.out.println(v[0]);
    }
}
