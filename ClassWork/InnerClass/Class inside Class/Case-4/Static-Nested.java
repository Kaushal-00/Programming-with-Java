class Outer {
    static class Nested {
        void display() {
            System.out.println("Inside Static Nested Class");
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Creating an instance of the Static Nested Class
        Outer.Nested obj = new Outer.Nested();
        obj.display();  // Output: Inside Static Nested Class
    }
}
