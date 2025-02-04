class Outer {
    private String message = "Hello from Outer";

    class Inner {
        void display() {
            System.out.println(message); // Accessing private member of Outer class
        }
    }

    // *
    // Method in Outer class to access Inner class
    // void accessInner() {
    //     Inner inner = new Inner(); // Creating Inner class object
    //     inner.display();           // Calling Inner class method
    // }
}

class Main {
    public static void main(String[] args) {
        Outer outer = new Outer(); // Creating Outer class instance

        // *
        // outer.accessInner();       // Calling method in Outer class that accesses Inner class
        
        Outer.Inner inner = outer.new Inner(); // Creating Inner class instance
        inner.display();
    }
}
