package aula08.Ex2;

public abstract class Alimento {
    protected double proteinas, calorias, peso;

    public Alimento(double proteinas, double calorias, double peso){
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.peso = peso;
    }

    public double getProteinas(){
        return this.proteinas;
    }
    
    public double getCalorias(){
        return this.calorias;
    }

    public double getPeso(){
        return this.peso;
    }

    protected abstract boolean isVegetariano();

    /*@Override
    public boolean equals(Object obj){

    }*/
    
}
