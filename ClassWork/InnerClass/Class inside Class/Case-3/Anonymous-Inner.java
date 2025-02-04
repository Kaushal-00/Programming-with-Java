class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Main {
    public static void main(String[] args) {
        // Anonymous Inner Class extending Animal
        Animal dog = new Animal() {
            void makeSound() {
                System.out.println("Dog barks!");
            }
        };
        
        dog.makeSound();  // Output: Dog barks!
    }
}
