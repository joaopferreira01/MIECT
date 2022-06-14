package aula03;
import java.util.Scanner;

public class exerc3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x;
        boolean primo = true;
        do {
            System.out.println("Digite um número inteiro positivo: ");
            x = sc.nextInt();
        } while (x<=0);
            
        for(int j = 2; j<x;j++){
            if(x % j == 0){
                primo = false;
                System.out.println("O número introduzido não é primo! ");
                break;
            }
        }
        if(primo) System.out.println("O número introduzido é primo!");


        sc.close();
    }    
}
