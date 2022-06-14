package aula08.Ex1;

public class Automovel extends Veiculo {

    private int numero_do_quadro;

    public Automovel(String matricula, String marca, String modelo, int potencia, int numero_do_quadro){
        super(matricula, marca, modelo, potencia);
        this.setNumeroDoQuadro(numero_do_quadro);
    }
    
    public void setNumeroDoQuadro(int numero_do_quadro){
        if(numero_do_quadro >= 0){
            this.numero_do_quadro = numero_do_quadro;
        }
    }

    public int getNumeroDoQuadro(){
        return this.numero_do_quadro;
    }
}
