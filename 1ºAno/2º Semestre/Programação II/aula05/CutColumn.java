import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CutColumn {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
      assert args.length >= 2: "Usage: java -ea CutColumn <source-file> <column-number>";
      int n = 0;
        try {
            n = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Second argumment must be a number!");
        }
        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String[] words = scanner.nextLine().split("[ \t]+");
                String palavra = "";
                if(words.length>=n){
                    palavra = words[n-1];
                    System.out.println(palavra);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("This file does not exist!");
        }
    } 
}
