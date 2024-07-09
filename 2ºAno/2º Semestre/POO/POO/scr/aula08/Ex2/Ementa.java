package aula08.Ex2;

import java.util.*;

public class Ementa {
    
    private String nome, local;
    private List<Prato> pratos = new ArrayList<Prato>();
    private List<DiasDaSemana> dias_da_semana = new ArrayList<DiasDaSemana>();

    public Ementa(String nome, String local){
        this.nome = nome;
        this.local = local;
    }

    public String getNome(){
        return this.nome;
    }

    public String getLocal(){
        return this.local;
    }

    public void addPrato(Prato prato, DiasDaSemana dia){
        pratos.add(prato);
        dias_da_semana.add(dia);
    }

    public List<Prato> getPratos(){
        return pratos;
    }

    public String toString(){
        String ementa = "";
        for(int i = 0; i < pratos.size(); i++){
            ementa += pratos.get(i) + ", dia " + dias_da_semana.get(i) + "\n";
        }
        return ementa;
    }

}
