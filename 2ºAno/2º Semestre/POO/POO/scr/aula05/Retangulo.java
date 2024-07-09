package aula05;


public class Retangulo {
    
    private double comprimento, altura;

    Retangulo(double comprimento, double altura){
       if(set(comprimento,altura)){
        this.comprimento = comprimento;
        this.altura = altura;
       }
    }

    public String toString(){
        return "Retangulo com " + this.comprimento + " de comprimento e " + this.altura+ " de altura";
    }

    public boolean equals(Retangulo r1){
        return this.comprimento == r1.getComprimento() && this.altura == r1.getAltura();
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
}
