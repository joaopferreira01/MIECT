package aula08.Ex1;

public class AutomovelPesadoMercadorias extends Pesado {
    private float max_carga;
    public AutomovelPesadoMercadorias(String matricula, String marca, String modelo, int potencia, int numero_do_quadro, float peso, float max_carga){
        super(matricula, marca, modelo, potencia, numero_do_quadro, peso);
        this.setMaxCarga(max_carga);
    }

    public void setMaxCarga(float max_carga){
        if(max_carga > 0){
            this.max_carga = max_carga;
        }
    }

    public float getMaxCarga(){
        return this.max_carga;
    }
    
    @Override
    public String toString() {
        return "PesadoMercadorias [id=" + this.getId() +", max_carga=" + this.getMaxCarga() + ", matricula=" + this.getMatricula() + ", marca=" + this.getMarca() + ", modelo=" + this.getModelo() + ", potencia=" + this.getPotencia() + ", numero_do_quadro=" + this.getNumeroDoQuadro() + ", peso=" + this.getPeso() + "]";
    }
}
