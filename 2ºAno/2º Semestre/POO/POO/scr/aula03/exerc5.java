package aula03;
import java.util.Scanner;

public class exerc5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int montante = 0,tax=0;
        while(montante <= 0 || (montante%1000 != 0)){
            System.out.println("Digite o montante que pretende investir:");
            montante = sc.nextInt();
        }
        do {
            System.out.println("Digite a taxa de juros que será aplicada:");
            tax = sc.nextInt();
        } while (tax < 0 || tax > 5);
        
        for(int i = 1; i <= 12;i++){
            montante += (montante*tax/100);
            System.out.print("O valor mensal do "+i+"º é mês: "+montante+" \n");
        }
        sc.close();
    }    
}
