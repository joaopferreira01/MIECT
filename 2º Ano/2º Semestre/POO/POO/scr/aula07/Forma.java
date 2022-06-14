package aula07;

public abstract class Forma {
    protected double area, perimetro;
    protected String cor;

    protected abstract double perimetro();
    protected abstract double area();
    public abstract boolean isFigValida();


    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getCor() {
        return this.cor;
    }
    public double getPerimetro() {
        return this.perimetro;
    }
    public double getArea() {
        return this.area;
    }

    public boolean equals(Forma f) {
        return this.toString().equals(f.toString());
    }
}