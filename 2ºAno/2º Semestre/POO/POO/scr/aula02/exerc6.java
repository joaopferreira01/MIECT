package aula02;
import java.util.Scanner;
public class exerc6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s, m, h;
        final String NORMAL = "\033[0m"; final String RED = "\033[0;31m"; 
    
        do{
            try {
                System.out.print("\nSeconds: ");
                s = sc.nextInt();
                if(s > 0) break;
                System.out.println(RED + "NEGATIVE NUMBER!" + NORMAL);
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);

        h = s / 3600;
        int resto = s % 3600;
        m = resto / 60;
        s = resto % 60;

        System.out.printf("%02d:%02d:%02d\n", h, m, s);
        sc.close();
    }
}