package aula02;
import java.util.Scanner;

public class exerc7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x1, y1, x2, y2;
        final String NORMAL = "\033[0m"; final String RED = "\033[0;31m"; 
    
        do{
            try {
                System.out.print("\nDigite as coordenadas em x do ponto p1: ");
                x1 = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);

        do{
            try {
                System.out.print("\nDigite as coordenadas em y do ponto p1: ");
                y1 = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);

        do{
            try {
                System.out.print("\nDigite as coordenadas em x do ponto p2: ");
                x2 = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);

        do{
            try {
                System.out.print("\nDigite as coordenadas em y do ponto p2: ");
                y2 = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);

        double distance = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));

        System.out.println(distance);

        sc.close();
    }
}
