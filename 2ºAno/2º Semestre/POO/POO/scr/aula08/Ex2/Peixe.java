package aula08.Ex2;

public class Peixe extends Alimento {
    
    private TipoPeixe tipo;

    public Peixe(TipoPeixe tipo, double proteinas, double calorias, double peso){
        super(proteinas, calorias, peso);
        this.tipo = tipo;
    }

    @Override
    public boolean isVegetariano(){
        return false;
    }

    public TipoPeixe getTipo(){
        return this.tipo;
    }

    @Override
    public String toString(){
        return "Peixe " + this.getTipo() + ", Proteinas " + this.getProteinas() + ", Calorias " + this.getCalorias() + ", Peso " + this.getPeso();
    }
}
