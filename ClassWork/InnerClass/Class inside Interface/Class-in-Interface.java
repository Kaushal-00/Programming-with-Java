interface Animal {
    class Dog {  // Class inside an interface
        void sound() {
            System.out.println("Bark!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
        Animal.Dog dog = new Animal.Dog();
        dog.sound();  // Output: Bark!
    }
}
