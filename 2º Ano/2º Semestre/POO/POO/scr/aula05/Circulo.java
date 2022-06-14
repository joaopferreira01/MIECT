package aula05;

public class Circulo {
	private double radius;

	Circulo(double radius) {
		this.setCircle(radius);
	}

	public double perimetro() {
		return 2 * Math.PI * this.radius;
	}

	public double area() {
		return Math.PI * this.radius * this.radius;
	}

	public String toString() {
		return "Círculo com raio: " + this.radius;
	}

	public boolean equals(Circulo b) {
		return this.radius == b.getRadius();
	}

	public double getRadius() {
		return this.radius;
	}

	public void setCircle(double radius) {
		assert radius > 0;
		this.radius = radius;
	}
}