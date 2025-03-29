import new_figures.Rectangle;
import new_figures.Triangle;

public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 10);
        Triangle tri = new Triangle(6, 8);

        rect.display();
        tri.display();
    }
}
