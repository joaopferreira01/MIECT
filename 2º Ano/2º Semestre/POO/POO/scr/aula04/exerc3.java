package aula04;
import java.util.Scanner;

public class exerc3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite uma frase:");
        String frase = sc.nextLine();

        System.out.println(getAcro(frase));
        sc.close();
    }   
    public static String getAcro(String s){
        String[] arrayOfString = s.split(" ");
        String acro ="";
        
        for(int i = 0; i < arrayOfString.length;i++){
            if(arrayOfString[i].length() > 3){
                acro += arrayOfString[i].charAt(0);
            }
        }
        return acro;
    }
}
