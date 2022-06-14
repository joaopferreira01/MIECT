package aula02;
import java.util.Scanner;

public class exerc1 {
    public static void main(String[] args) {
        final String NORMAL = "\033[0m"; final String RED = "\033[0;31m";
        Scanner sc = new Scanner(System.in);
        double milhas;
        
        do{
            try {
                    System.out.print("\nQuilómetros: ");
                    milhas = sc.nextDouble();
                    if(milhas > 0) break;
                    System.out.println(RED + "NEGATIVE NUMBER!" + NORMAL);
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);
    
        System.out.println("O valor correspondente em milhas é: "+ milhas/1.609);

        sc.close();
    }
}
