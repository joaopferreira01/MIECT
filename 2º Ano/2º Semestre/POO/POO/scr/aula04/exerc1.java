package aula04;
import java.util.Scanner;

public class exerc1 {
   public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String text;
        do {
            System.out.println("Digite um texto");
            text = sc.nextLine();

        } while (text.isEmpty());

        
        if(text.length()>2){
            System.out.println("\nTexto em minúsculas: "+text.toLowerCase());
            System.out.println("\nÚltimo caratere: "+text.charAt(text.length()-1));
            System.out.println("\nTrês primeiros carateres: "+text.substring(0,3));
            System.out.println("\nTroca de v por f: "+text.replace("v", "f"));
            System.out.println("\nA string introduzida contém o caratere a? "+text.contains("a"));
            System.out.println("\n"+text.concat(".\nProgramação é fixe."));
        }else{
            System.out.println("A string introduzida contém menos de 3 caracteres!");
        }
        sc.close();
    } 
}
