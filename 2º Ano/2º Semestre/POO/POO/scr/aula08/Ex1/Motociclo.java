package aula08.Ex1;

public class Motociclo extends Veiculo {
    
    private String tipo;

    public Motociclo(String matricula, String marca, String modelo, int potencia, String tipo){
        super(matricula, marca, modelo, potencia);
        this.setTipo(tipo);

    }

    public void setTipo(String tipo){
        if(tipo != null && !tipo.equals("")){
            this.tipo = tipo;
        }
    }

    public String getTipo(){
        return this.tipo;
    }

    @Override
    public String toString() {
        return "Motociclo [id=" + this.getId() + ", tipo=" + this.getTipo() + ", matricula=" + this.getMatricula() + ", marca=" + this.getMarca() + ", modelo=" + this.getModelo() + ", potencia=" + this.getPotencia() + "]";
    }
}
