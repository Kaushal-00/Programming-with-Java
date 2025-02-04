interface Flyable {
    void fly();
}

interface Swimable {
    void swim();
}

class Bird implements Flyable, Swimable { //Multiple Inheritance
    public void fly() {
        System.out.println("Bird is flying.");
    }

    public void swim() {
        System.out.println("Bird is swimming.");
    }
}

class Main {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
        bird.swim();
    }
}
