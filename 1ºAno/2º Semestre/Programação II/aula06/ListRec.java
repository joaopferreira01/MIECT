import java.*;

public class ListRec {
    
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
            System.out.print("Directory does not exist.");
        }
    }
    public static void listFiles(File dir){
        
    }
}
