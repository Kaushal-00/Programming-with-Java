interface Animal {
    void eat();  
    void sleep(); 
}

class Dog implements Animal {
    public void eat() {  
        System.out.println("Dog is eating.");
    }

    public void sleep() { 
        System.out.println("Dog is sleeping.");
    }
}

// Main method
public class Interfaces{
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.sleep();
    }
}
