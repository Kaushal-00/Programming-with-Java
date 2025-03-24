public class TestShape {
    public static void main(String[] args) {

        Rectangle rect = new Rectangle(5, 10);
        rect.describe();
        System.out.println("Area of Rectangle: " + rect.area());
        System.out.println("Perimeter of Rectangle: " + rect.perimeter());
        System.out.println();

        Cone cone = new Cone(3, 7);
        cone.describe();
        System.out.println("Volume of Cone: " + cone.volume());
        System.out.println();

        Sphere sphere = new Sphere(4);
        sphere.describe();
        System.out.println("Volume of Sphere: " + sphere.volume());
    }
}