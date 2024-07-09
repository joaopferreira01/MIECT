package aula07;

public class Circulo extends Forma {
	private double radius;

	Circulo(double radius, String cor) {
		this.setCircle(radius);
        this.cor = cor;
	}

	protected double perimetro() {
        return this.perimetro = 2 * Math.PI * this.getRadius();
    }

    protected double area() {
        return this.area = Math.PI * this.getRadius() * this.getRadius();
    }

	public String toString() {
		return "Círculo com raio: " + this.radius;
	}

	public boolean equals(Circulo b) {
		return this.radius == b.getRadius() && this.getCor() == b.getCor();
	}

	public double getRadius() {
		return this.radius;
	}

	public void setCircle(double radius) {
		assert radius > 0;
		this.radius = radius;
	}
    public boolean isFigValida() {
        return this.getRadius() > 0;
    }

}