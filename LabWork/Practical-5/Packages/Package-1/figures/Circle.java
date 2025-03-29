package figures;

public class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return 3.14159 * radius * radius;
    }

    public void displayCircle() {
        System.out.println("Circle radius: " + radius);
        System.out.println("Circle area: " + calculateArea());
    }
}