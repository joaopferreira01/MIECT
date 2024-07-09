package aula10;

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Ex2 {
    public static void main (String[] args){
        Map<String, ArrayList<String>> mapa = new TreeMap<>();

        mapa.put("branco", new ArrayList<String>(Arrays.asList("que tem a cor da neve")));
        mapa.put("preto", new ArrayList<String>(Arrays.asList("que tem a cor da noite")));
        mapa.put("vermelho", new ArrayList<String>(Arrays.asList("que tem a cor do sangue")));
        mapa.put("azul", new ArrayList<String>(Arrays.asList("que tem a cor do mar")));
        mapa.put("amarelo", new ArrayList<String>(Arrays.asList("que tem a cor do sol")));
        //mapa.put("vermelho", new ArrayList<String>(Arrays.asList("que tem a cor do GLORIOSO")));
        mapa.put("laranja", new ArrayList<String>(Arrays.asList("que tem a cor da laranja")));
        
        mapa.remove("laranja");
        mapa.remove("amarelo");

        System.out.println(mapa.get("branco"));
        System.out.println(mapa.get("vermelho"));

        mapa.put("azul", new ArrayList<String>(Arrays.asList("que tem a cor da água"))); // Substitui o value
        //mapa.get("verde").add("que tem a cor do verde"); // Adiciona mais values
        mapa.get("branco").add("que tem a cor do leite");
        mapa.get("branco").add("que tem a cor de alguma coisa");
        mapa.get("branco").add("que tem a cor da parede");
        mapa.get("branco").add("que tem a cor do papel");
        mapa.get("branco").add("que tem a cor do homem-aranha");
        mapa.get("branco").add("que tem a cor do giz");
        

        System.out.println(mapa.get("branco"));
        System.out.println(mapa.get("azul"));
        System.out.println();

        // ToString
        System.out.println(mapa.toString());
        System.out.println();

        // Apenas Keys
        System.out.println(mapa.keySet());
        System.out.println();

        // Apenas Values
        System.out.println(mapa.values());
        System.out.println();


    }
}
