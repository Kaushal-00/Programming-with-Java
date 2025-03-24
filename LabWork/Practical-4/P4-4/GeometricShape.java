public interface GeometricShape {
    public void describe();
}

interface TwoDShape extends GeometricShape {
    public double area();
}

interface ThreeDShape extends GeometricShape {
    public double volume();
}

class Cone implements ThreeDShape {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double volume() {
        return (1.0 / 3) * Math.PI * radius * radius * height;
    }

    public void describe() {
        System.out.println("This is a Cone with radius " + radius + " and height " + height);
    }
}

class Rectangle implements TwoDShape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public void describe() {
        System.out.println("This is a Rectangle with width " + width + " and height " + height);
    }
}

class Sphere implements ThreeDShape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double volume() {
        return (4.0 / 3) * Math.PI * radius * radius * radius;
    }

    public void describe() {
        System.out.println("This is a Sphere with radius " + radius);
    }
}