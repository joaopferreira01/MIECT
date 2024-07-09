package aula02;
import java.util.Scanner;

public class exerc5 {
    public static void main(String[] args){
        final String NORMAL = "\033[0m"; final String RED = "\033[0;31m";
        Scanner sc = new Scanner(System.in);
        double d1, d2, v1, v2;

        do{
            try {
                System.out.println("v1: ");
                v1 = sc.nextDouble();
                if(v1 > 0) break;
                System.out.println(RED + "NEGATIVE NUMBER!" + NORMAL);
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);

        do{
            try {
                System.out.println("d1: ");
                d1 = sc.nextDouble();
                if(d1 > 0) break;
                System.out.println(RED + "NEGATIVE NUMBER!" + NORMAL);
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);

        do{
            try {
                System.out.println("v2: ");
                v2 = sc.nextDouble();
                if(v2 > 0) break;
                System.out.println(RED + "NEGATIVE NUMBER!" + NORMAL);
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);

        do{
            try {
                System.out.println("d2: ");
                d2 = sc.nextDouble();
                if(d2 > 0) break;
                System.out.println(RED + "NEGATIVE NUMBER!" + NORMAL);
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);

        double distance = d1+d2;
        double time = d1/v1+d2/v2;

        System.out.println("Velocidade média: "+distance/time);
        sc.close();
    }
}
