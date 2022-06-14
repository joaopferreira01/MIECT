package aula08.Ex1;

public class AutomovelPesadoPassageiros extends Pesado {

    private int num_max_de_passageiros;

    public AutomovelPesadoPassageiros(String matricula, String marca, String modelo, int potencia, int numero_do_quadro, float peso, int num_max_de_passageiros){
        super(matricula, marca, modelo, potencia, numero_do_quadro, peso);
        this.setNumMaxDePassageiros(num_max_de_passageiros);


    }

    public void setNumMaxDePassageiros(int num_max_de_passageiros){
        if(num_max_de_passageiros > 0){
            this.num_max_de_passageiros = num_max_de_passageiros;
        }
    }

    public int getNumMaxDePassageiros(){
        return this.num_max_de_passageiros;
    }

    @Override
    public String toString() {
        return "PesadoPassageiros [id=" + this.getId() + ", numero_max_de_passageiros=" + this.getNumMaxDePassageiros() + ", matricula=" + this.getMatricula() + ", marca=" + this.getMarca() + ", modelo=" + this.getModelo() + ", potencia=" + this.getPotencia() + ", numero_do_quadro=" + this.getNumeroDoQuadro() + ", peso=" + this.getPeso() + "]";
    }
    
}
