package aula07;

public class Triangulo extends Forma{

    private double lado1, lado2, lado3;

    Triangulo(double lado1, double lado2, double lado3, String cor){
        if(set(lado1, lado2, lado3)){
            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;
            this.cor = cor;
        }
    }

    public static boolean set(double lado1, double lado2, double lado3){
        if(lado1 >= 1 && lado2 >= 1 && lado3 >= 1 && lado1 < (lado2 + lado3) && (lado2 < (lado1 + lado3) && lado3 < (lado1 + lado2))){
            return true;
        }
        return false;
    }

    public double area(){
        double p = (this.lado1+this.lado2+this.lado3)/2;  // Podia juntar tudo, mas não quero carrosel
        return Math.sqrt(p*(p-this.lado1)*(p-this.lado2)*(p-this.lado3));
    }

    public boolean equals(Triangulo t){
        return this.lado1 == t.getLado1() && this.lado2 == t.getLado2() && this.lado3 == t.getLado3() && this.getCor() == t.getCor();
    }

    public double perimetro(){
        return this.lado1 + this.lado2 + this.lado3;
    }

    public String toString(){
        return "Triângulo com lados:\tA = " + this.lado1 + "\tB = " + this.lado2 + "\tC = "+this.lado3;
    }

    public double getLado1(){
        return this.lado1;
    }
    
    public double getLado2(){
        return this.lado2;
    }

    public double getLado3(){
        return this.lado3;
    }
    public boolean isFigValida() {
        if (this.lado1 <= 0 || this.lado2 <= 0 || this.lado3 <= 0)
            return false;
        if (this.lado1 + this.lado2 <= this.lado3 || this.lado1 + this.lado3 <= this.lado2 || this.lado2 + this.lado3 <= this.lado1)
            return false;
        return true;
    }
}
