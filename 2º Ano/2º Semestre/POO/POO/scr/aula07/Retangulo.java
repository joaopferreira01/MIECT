package aula07;


public class Retangulo extends Forma {
    
    private double comprimento, altura;

    Retangulo(double comprimento, double altura, String cor){
       if(set(comprimento,altura)){
        this.comprimento = comprimento;
        this.altura = altura;
        this.cor = cor;
       }
    }

    public String toString(){
        return "Retangulo com " + this.comprimento + " de comprimento e " + this.altura+ " de altura, de cor " + this.cor;
    }

    public boolean equals(Retangulo r1){
        return this.comprimento == r1.getComprimento() && this.altura == r1.getAltura() && this.getCor() == r1.getCor();
    }

    public boolean set(double comprimento, double altura){
        return comprimento > 0 && altura > 0;
    }

    public double area(){
        return this.comprimento*this.altura;
    }

    public double perimetro(){
        return 2*this.altura + 2*this.comprimento;
    }

    public double getComprimento(){
        return this.comprimento;
    }

    public double getAltura(){
        return this.altura;
    }
    public boolean isFigValida() {
        return this.getComprimento() > 0 && this.getAltura() > 0;
    }
}
