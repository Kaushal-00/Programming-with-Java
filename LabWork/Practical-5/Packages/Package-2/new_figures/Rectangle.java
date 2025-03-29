package new_figures;
import figures.Shape; // Importing Shape from figures package

public class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public void display() {
        System.out.println("Rectangle with length " + length + " and width " + width);
        System.out.println("Area: " + calculateArea());
    }
}