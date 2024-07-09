package aula02;
import java.util.Scanner;

public class exerc4 {
    public static void main(String[] args) {
        final String NORMAL = "\033[0m"; final String RED = "\033[0;31m";
        Scanner sc = new Scanner(System.in);
        double montante, taxa;

        do{
            try {
                System.out.println("Digite o montante que pretende investir: ");
                montante = sc.nextDouble();
                if(montante > 0) break;
                System.out.println(RED + "NEGATIVE NUMBER!" + NORMAL);
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);

        do{
            try {
                System.out.println("Digite a taxa de juros: ");
                taxa = sc.nextDouble();
                if(taxa > 0) break;
                System.out.println(RED + "NEGATIVE NUMBER!" + NORMAL);
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);

        taxa = taxa/100;
        
        for(int i=0; i<3; i++){
            montante += montante*taxa;
        }

        System.out.println(montante);
        sc.close();
    }    
}
