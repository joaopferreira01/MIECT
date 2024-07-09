package aula10;

import java.util.Map;
import java.util.HashMap;

public class Ex1 {
    public static void main (String[] args) {
        Map<String, String> mapa = new HashMap<>();

        mapa.put("branco", "que tem a cor da neve");
        mapa.put("preto","que tem a cor da noite");
        mapa.put("vermelho","que tem a cor do GLORIOSO");
        mapa.put("azul", "que tem a cor do mar");
        mapa.put("amarelo","que tem a cor do sol");
        mapa.put("verde","que tem a cor da relva");
        mapa.put("laranja","que tem a cor da laranja. LOL");

        mapa.remove("amarelo");
        mapa.remove("laranja");

        System.out.println(mapa.get("branco"));

        System.out.println(mapa.toString());

        System.out.println(mapa.keySet());
        
        System.out.println(mapa.values());

    }
}
