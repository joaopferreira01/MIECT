package aula08.Ex1;

public class AutomovelLigeiro extends Automovel {

    private float capacidade_bagageira;

    public AutomovelLigeiro(String matricula, String marca, String modelo, int potencia, int numero_do_quadro, float capacidade_bagageira){
        super(matricula, marca, modelo, potencia, numero_do_quadro);
        this.setCapacidadeBagageira(capacidade_bagageira);
    }

    public void setCapacidadeBagageira(Float capacidade_bagageira){
        if(capacidade_bagageira > 0){
            this.capacidade_bagageira = capacidade_bagageira;
        }
    }

    public float getCapacidadeBagageira(){
        return this.capacidade_bagageira;
    }

    @Override
    public String toString() {
        return "LigeiroPassageiros [id=" + this.getId() + ", capacidade_bagageira=" + this.getCapacidadeBagageira() + ", matricula=" + this.getMatricula() + ", marca=" + this.getMarca() + ", modelo=" + this.getModelo() + ", potencia=" + this.getPotencia() + ", numero_do_quadro=" + this.getNumeroDoQuadro() + "]";
    }
}
