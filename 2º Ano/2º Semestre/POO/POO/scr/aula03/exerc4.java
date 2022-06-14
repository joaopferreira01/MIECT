package aula03;
import java.util.Scanner;

public class exerc4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        double n,a,max,min,soma;
        int i;

        System.out.println("Digite um número");
        a = sc.nextDouble();

        max = a;
        min = a;
        soma = a;
        n = a+1;

        for(i = 1; n!=a;i++){
            System.out.println("Digite um número");
            n = sc.nextDouble();
            if(n > max){
                max = n;
            }else if(n < min){
                min = n;
            }
            soma += n;
        }
        
        System.out.println("Média: "+soma/i);
        System.out.println("Números lidos: "+i);
        System.out.println("Valor máximo: "+max);
        System.out.println("Valor mínimo: "+min);

        sc.close();
    }    
}
