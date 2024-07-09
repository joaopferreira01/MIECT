/*
 * JAM, 2-nov-2020
 * Ler notas de 0 a 20 (terminar com valor negativo) e calcular media
 */
import java.util.Scanner;

public class Media {

    public static void main(String[] args) {
        // Scanner para leitura de dados do teclado
        Scanner ler = new Scanner(System.in);

        int nota, soma=0, num=0;
        float media;
        System.out.println("Introduza as notas dos alunos (<0 termina):");
        System.out.printf("Nota aluno %3d: ",num+1);
        nota = ler.nextInt();
        while (nota >= 0) {
            soma = soma + nota;
            num = num +1;
            System.out.printf("Nota aluno %3d: ",num+1);
            nota = ler.nextInt();
        }
        media = (float)soma/num;
        System.out.printf("Soma = %3d\nMedia = %4.1f\n",soma,media);
    }
}
