package aula03;
import java.util.Scanner;

public class exerc2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número para fazer uma contagem decrescente:");
        int counter = sc.nextInt();

        for(int i=counter; i>=0;i--){
            System.out.println(i);
        }
        sc.close();
    }    
}
