import java.util.Scanner;
import java.io.*;
import java.io.PrintWriter;

public class CopyFile {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //assert args.length >= 2;
        File firstFile = new File(args[0]);
        assert firstFile.exists();
        assert firstFile.canRead();
        assert firstFile.isFile();
        File secondFile = new File(args[1]);
        Scanner scfScanner = new Scanner(firstFile);
        PrintWriter pdf = new PrintWriter(secondFile);
        if (secondFile.exists()) {
            System.out.print("Deseja reescrever o ficheiro Y/N?\n");
            String coiso = scanner.nextLine();
            assert (coiso.equals("Y") || coiso.equals("y") || coiso.equals("n") || coiso.equals("N"));
            if (coiso.equals("Y") || coiso.equals("y")) {
                copyFile(firstFile, secondFile, scfScanner, pdf);

            }
        } else {
            File newFile = new File("C:/Users/João/Desktop/Faculdade/2ºSemestre/Programação II/aula05");
            assert newFile.canWrite();
        }
    }

    public static void copyFile(File one, File two, Scanner ler, PrintWriter escrever) {
        while (ler.hasNextLine()) {
            escrever.println(ler.nextLine());
        }
        escrever.close();
        ler.close();
    }

}
