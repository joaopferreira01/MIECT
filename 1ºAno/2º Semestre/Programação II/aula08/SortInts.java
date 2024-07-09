import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;

public class SortInts
{
  public static void main(String[] args) throws IOException {
    //...
    SortedListInt list = new SortedListInt();

    for(int i = 0; i < args.length; i++){
      File file = new File(args[i]);
      Scanner scanner = new Scanner(file);
      while(scanner.hasNextLine()){
        String data = scanner.nextLine();
        try {
          int n = Integer.parseInt(data);
          list.insert(n);
        } catch (NumberFormatException e) {
          //TODO: handle exception
        }
      }
      scanner.close();
    }
    while(!list.isEmpty()){
      out.println(list.first());
      list.removeFirst();
    }
  }

}


