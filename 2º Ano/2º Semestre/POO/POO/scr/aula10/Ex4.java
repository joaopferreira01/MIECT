package aula10;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.FileReader;
import java.io.IOException;

public class Ex4 {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(new FileReader("major.txt"));

        Set<String> words = new HashSet<>();
        String word = "";
        while (scan.hasNext()) {
            word = scan.next();
            if(word.length() > 2){
                words.add(word);
            }
        }
        scan.close();
        System.out.println(words);
        
        endsWithS(words);
        removeLetter(words);
    }

    private static void removeLetter(Set<String> words) {
        Iterator<String> it = words.iterator();
        
        while(it.hasNext()) {
            String w = it.next();
            if (!w.matches("[a-zA-Z]+")) { 
                it.remove();
            }
        }
        System.out.println(words);
    }

    public static void endsWithS(Set<String> words){
        for(String w : words){
            if(w.endsWith("s")){
                System.out.println(w);
            }
        }
        System.out.println();
        System.out.println();
    }
}
