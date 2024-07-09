package aula02;
import java.util.Scanner;

public class exerc8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int c1, c2;
        final String NORMAL = "\033[0m"; final String RED = "\033[0;31m"; 
    
        do{
            try {
                System.out.print("\nDigite o primeiro cateto do triângulo: ");
                c1 = sc.nextInt();
                if(c1 > 0) break;
                System.out.println(RED + "NEGATIVE NUMBER!" + NORMAL);
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);
        do{
            try {
                System.out.print("\nDigite o segundo cateto do triângulo: ");
                c2 = sc.nextInt();
                if(c2 > 0) break;
                System.out.println(RED + "NEGATIVE NUMBER!" + NORMAL);
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);

        double hip = Math.sqrt(Math.pow(c1, 2)+Math.pow(c2, 2));
        double angle = Math.acos(c1/hip)*180/Math.PI;

        System.out.println("O valor da hipotenusa do triângulo é "+hip+" e o ângulo formado entre o primeiro lado e a hipotenusa é "+angle);

        sc.close();
    }    
}

