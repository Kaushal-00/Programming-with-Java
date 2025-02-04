class Outer {
    void display() {  // Method inside Outer class
        class Inner {  // Method-local inner class
            void show() {
                System.out.println("Hello from Method-Local Inner Class!");
            }
        }
        Inner inner = new Inner(); // Creating object of Inner class
        inner.show(); // Calling method of Inner class
    }
}

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer(); // Creating Outer class object
        outer.display(); // Calling method that contains Inner class
    }
}
