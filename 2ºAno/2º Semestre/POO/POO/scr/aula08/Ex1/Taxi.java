package aula08.Ex1;



public class Taxi extends Automovel {
    private int numero_licensa;
    Taxi(String matricula, String marca, String modelo, int potencia, int numero_do_quadro, int numero_licensa){
        super(matricula, marca, modelo, potencia, numero_do_quadro);
        this.setNumeroLicensa(numero_do_quadro);
    }
    
    public void setNumeroLicensa(int numero_licensa){
        if(numero_licensa > 0){
            this.numero_licensa = numero_licensa;
        }
    }

    public int getNumeroLicensa(){
        return this.numero_licensa;
    }

    @Override
    public String toString() {
        return "Taxi [id=" + this.getId() + ", numero_licensa=" + this.getNumeroLicensa() + ", matricula=" + this.getMatricula() + ", marca=" + this.getMarca() + ", modelo=" + this.getModelo() + ", potencia=" + this.getPotencia() + ", numero_do_quadro=" + this.getNumeroDoQuadro() + "]";
    }
}
