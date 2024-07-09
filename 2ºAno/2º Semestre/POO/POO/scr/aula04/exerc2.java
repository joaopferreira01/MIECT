package aula04;
import java.util.Scanner;

public class exerc2 {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite uma frase");
            String text = sc.nextLine();

            System.out.println("Dígitos da frase: "+countDigits(text));
            System.out.println("Número de espaços: "+numOfSpaces(text));
            System.out.println("Só contém minúsculas? "+onlyLowerCase(text));
            System.out.println("A mesma string, mas sem espaços duplos: "+removeDoubleSpaces(text));
            System.out.println("A string é palíndromo? "+isPalindrome(text));

            sc.close();
        }
        public static int countDigits(String s){
            int count=0;
            for(int i = 0; i<s.length();i++){
                if(Character.isDigit(s.charAt(i))){
                    count++;
                }
            }
            return count; 
        }
        public static int numOfSpaces(String s){
            int count=0;
            for(int i = 0; i<s.length();i++){
                char c = s.charAt(i);
                if(c == ' '){
                    count++;
                }
            }
            return count;
        }
        public static boolean onlyLowerCase(String s){
            return s.equals(s.toLowerCase());
        }
        public static String removeDoubleSpaces(String s){
            return s.replaceAll("[ ]+", " ");
        }
        public static boolean isPalindrome(String s){
            int x = s.length() - 1;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != s.charAt(x)){
                    return false;
                }
                x--;
            }
            return true;
        }
}
