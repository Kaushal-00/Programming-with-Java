class Animal {
    String type = "Animal"; // Parent class variable

    // Parent Constructor
    Animal() {
        System.out.println("Animal constructor called.");
    }

    // Parent Method
    void sound() {
        System.out.println("Animal makes a sound.");
    }
}

class Dog extends Animal {
    String type = "Dog"; // Child class variable

    // Child Constructor
    Dog() {
        super();  // Calls Parent Constructor
        System.out.println("Dog constructor called.");
    }

    // Overriding Parent Method
    @Override
    void sound() {
        super.sound();  // Calls Parent Method
        System.out.println("Dog barks!");
    }

    void showType() {
        System.out.println("Type from subclass: " + type);
        System.out.println("Type from superclass: " + super.type); // Access Parent Variable
    }
}


public class Super {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();
        dog.showType();
    }
}
