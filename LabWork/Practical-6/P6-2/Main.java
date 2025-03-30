public class Main {
    public static void main(String[] args) {
        // Integer Stack
        GenericStack<Integer> intStack = new GenericStack<>(5);
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.display();

        System.out.println("Popped: " + intStack.pop());
        intStack.display();

        // String Stack
        GenericStack<String> stringStack = new GenericStack<>(3);
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.display();
    }
}
