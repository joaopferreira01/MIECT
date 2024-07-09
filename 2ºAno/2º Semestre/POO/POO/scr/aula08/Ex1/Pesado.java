package aula08.Ex1;



public abstract class Pesado extends Automovel{

    private float peso;
    public Pesado(String matricula, String marca, String modelo, int potencia, int numero_do_quadro, float peso){
        super(matricula, marca, modelo, potencia, numero_do_quadro);
        this.setPeso(peso);
    }

    public float getPeso(){
        return this.peso;
    }

    public void setPeso(float peso){
        if(peso > 0){
            this.peso = peso;
        }

    }

    
}
