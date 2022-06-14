package aula02;
import java.util.Scanner;

public class exerc3 {
    public static void main(String[] args){
        final String NORMAL = "\033[0m"; final String RED = "\033[0;31m";
        Scanner sc = new Scanner(System.in);
        double agua, fin, inicio;

        do{
            try {
                System.out.println("Digite a quantidade de água em  quilogramas: ");
                agua = sc.nextDouble();
                if(agua > 0) break;
                System.out.println(RED + "NEGATIVE NUMBER!" + NORMAL);
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);
        
        do{
            try {
                System.out.println("Digite a temperatura final da água: ");
                fin = sc.nextDouble();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);

        do{
            try {
                System.out.println("Digite a temperatura inicial da água: ");
                inicio = sc.nextDouble();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println(RED + "NOT A NUMBER!" + NORMAL);
            }
        } while(true);


        double carga = agua*(fin-inicio)*4184;
        System.out.println("A energia necessária para aquecer a água é de: "+carga);

        sc.close();
    }
}
