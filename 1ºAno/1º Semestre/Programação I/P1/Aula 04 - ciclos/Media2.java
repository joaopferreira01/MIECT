/*
 * JAM, 2-nov-2019
 * Ler notas de 0 a 20 (terminar com valor negativo) e calcular media
 * do ... while 
 */
import java.util.Scanner;

public class Media2 {

    public static void main(String[] args) {
        // Scanner para leitura de dados do teclado
        Scanner ler = new Scanner(System.in);

        int nota = 0, soma = 0, num = 0;
        float media;
        System.out.println("Introduza as notas dos alunos (<0 termina):");

        do {
            soma = soma + nota;
            num = num + 1;
            System.out.printf("Nota aluno %3d: ",num);
            nota = ler.nextInt();
        } while (nota >= 0);
        
        media = (float)soma/--num;	// atenção, num-- não funciona!
        
        System.out.printf("Soma = %3d\nMedia = %4.1f\n",soma,media);
    }
}
