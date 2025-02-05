interface Animal {
    
    interface Sound {
        void makeSound();
    }
}

class Dog implements Animal.Sound {
    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }
}

class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();  // Output: Bark!
    }
}
