import java.util.*;
import java.io.File;

public class ListDir {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        String diretorio;
        if(args.length >= 1){
            diretorio = args[0];
        }else{
            diretorio = "./";
        }
        try {
            File dir = new File(diretorio);
            listFiles(dir);
        } catch (NullPointerException e) {
            System.out.println("Directory does not exist!");
        }
    }
    public static void listFiles(File dir){
        File list[] = dir.listFiles();
        for(int i = 0; i <= list.length; i++){
            String coiso = "";
            if(list[i].isDirectory())
                coiso += "D";
            else
                coiso +="F";
            if(list[i].canRead())
                coiso += "R";
            else    
                coiso += "-";
            if(list[i].canWrite())
                coiso += "W";
            else    
                coiso += "-";
            File arquivos = list[i];
            System.out.println(coiso+"\t"+arquivos.getPath());
        }
    }
}
