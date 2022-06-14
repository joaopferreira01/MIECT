package aula08.Ex2;

import java.util.ArrayList;
import java.util.List;

public class Prato implements Comparable<Prato>{

    private String nome;
    protected List<Alimento> alimentos = new ArrayList<Alimento>();

    public Prato(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public boolean addIngrediente(Alimento alimento){
        return alimentos.add(alimento);
    }

    public List<Alimento> addAlimentos(){
        return this.alimentos;
    }

    public double getCalorias(){
        double calorias = 0;
        for(Alimento alimento : alimentos){
            calorias += (alimento.getCalorias()*alimento.getPeso()/100);
        }
        return calorias;
    }

    public double getProteinas(){
        double proteinas = 0;
        for(Alimento alimento : alimentos){
            proteinas += (alimento.getProteinas()*alimento.getPeso()/100);
        }
        return proteinas;
    }

    public double getPeso(){
        double peso = 0;
        for(Alimento alimento : alimentos){
            peso += (alimento.getPeso());
        }
        return peso;
    }

    @Override
    public int compareTo(Prato p){
        if((this.getCalorias() > p.getCalorias())) return 1;
        if((this.getCalorias() < p.getCalorias())) return -1;
        return 0;

    }

    @Override 
    public String toString() {
        return "Prato '" + this.getNome() + "', composto por " + alimentos.size() + " Ingredientes";
    }
    
}
