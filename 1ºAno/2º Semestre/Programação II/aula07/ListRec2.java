import static java.lang.System.*;
import java.io.File;

import p2utils.LinkedList;

public class ListRec2 {

  public static void main(String[] args) {
    assert args.length > 0 : "Uso: java -ea ListRec2 <dir>";
    String dirPath;
    if(args.length >= 1){
      dirPath = args[1];
    }else{
      dirPath = "./";
    }
    LinkedList<File> list = new LinkedList<File>();
    try {
      File dir = new File(dirPath);
      recListFiles(list, dir);
    } catch (NullPointerException e) {
      System.err.println("Invalid Path");
      System.exit(2);
    }
  }

  /** Devolve uma lista com o conteúdo de um directório f
   *  e de todos os seus subdirectórios recursivamente.
   */
  public static void recListFiles(LinkedList<File> list, File dir) {
    //...
    
  }
}
