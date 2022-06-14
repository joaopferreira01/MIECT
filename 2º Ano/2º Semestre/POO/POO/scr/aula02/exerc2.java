package aula02;
import java.util.Scanner;

public class exerc2 {
    public static void main(String[] args){
        final String NORMAL = "\033[0m"; final String RED = "\033[0;31m";
        Scanner sc = new Scanner(System.in);
        double graus;
        
        do{
            try {
                System.out.print("\nDigite a temperatura em graus Celsius: ");
                graus = sc.nextDouble();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);
        
        graus = 1.8*graus + 32;
        System.out.println("O equivalente em graus Fahrenheit é: "+graus);

        sc.close();
    }
}
