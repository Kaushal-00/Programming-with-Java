package new_figures;
import figures.Shape; // Importing Shape from figures package

public class Triangle extends Shape {
    private double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public void display() {
        System.out.println("Triangle with base " + base + " and height " + height);
        System.out.println("Area: " + calculateArea());
    }
}
