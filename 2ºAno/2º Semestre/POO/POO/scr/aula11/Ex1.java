package aula11;

import java.io.*;
import java.util.*;

public class Ex1 {
    public static void main(String[] args) throws IOException {
        Map<String, TreeMap<String, Integer>> map = new TreeMap<>();
        ArrayList<String> list = new ArrayList<>();

        try{
            Scanner input = new Scanner(new File("major.txt"), "UTF-8");
            while(input.hasNext()){
                String s = input.next();

                s = s.replaceAll("[^a-zA-Z0-9]", " ");
                if(s.matches("\\w{3,}")){
                    list.add(s);
                }
            }
            for(int j = 1; j < list.size(); j++){
                int i = j - 1;
                if(map.containsKey(list.get(i))){
                    TreeMap<String, Integer> b = map.get(list.get(i));
                    if(b.containsKey(list.get(j))){
                        int c = b.get(list.get(j));
                        //c++;
                        b.put(list.get(j), ++c);
                    }else{
                        b.put(list.get(j), 1);
                    }
                    map.put(list.get(i), b);
                }else{
                    TreeMap<String, Integer> b = new TreeMap<>();
                    b.put(list.get(j), 1);
                    map.put(list.get(i), b);
                }
            }
            System.out.println(map);            
        }catch(FileNotFoundException e){
            System.out.println("Ficheiro não encontrado!");
        }
    }
}