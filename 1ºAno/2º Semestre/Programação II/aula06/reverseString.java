import java.util.Scanner;

public class reverseString {
    public static void main(String[] args){
        for(int i = 0; i < args.length; i++){
            reverse(args[i], args[i].length());
            System.out.println();
        }
    }
    public static void reverse(String frase, int n){
        if (n == 0) return;
        System.out.println(frase.charAt(n-1));
        reverse(frase, n-1);
        
        
    }
}