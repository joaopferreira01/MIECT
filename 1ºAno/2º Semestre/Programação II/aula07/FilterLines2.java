import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;
// import java.util.*;   // => "error: reference to LinkedList is ambiguous"
// java.util.LinkedList colide com p2utils.LinkedList!
import p2utils.*;

public class FilterLines2
{
  public static void main(String[] args) throws IOException
  
  {
    // Criar listas para as linhas curtas, médias e longas.
    LinkedList<String> lista = new LinkedList<String>();
    if (args.length != 1) {
      err.printf("Usage: java -ea FilterLines text-file\n");
      exit(1);
    }
    try {
      File fil = new File("input.txt");
      Scanner sf = new Scanner(fil);
      while (sf.hasNextLine()) {
        String line = sf.nextLine();
        // Guardar linha na lista apropriada, consoante o tamanho.
        if(line.length()<20){
          lista.addFirst(line);
        }else{
          lista.addLast(line);
        }
      }
      sf.close();
    } catch (FileNotFoundException e) {
      System.out.println("Ficheiro não existe");
    }
    // exceções poderiam ser intercetadas e mostrar mensagem de erro.
    // Escrever conteúdo das listas...
    lista.print();
  }
}
