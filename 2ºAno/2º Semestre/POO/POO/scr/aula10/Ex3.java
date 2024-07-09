package aula10;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Ex3 {
    public static void main(String[] args){
        System.out.println("vamos avaliar a posição dos carateres presentes em: * Hello World *");
        System.out.println(charPositionInString("Hello World"));
    } 
    public static String charPositionInString(String s){
        Map<Character, ArrayList<Integer>> mapa = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            mapa.put(c, new ArrayList<>());
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            mapa.get(c).add(i);
        }
        return mapa.toString();

    }
}
