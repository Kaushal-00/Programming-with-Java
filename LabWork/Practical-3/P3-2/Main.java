public class Main {
    public static void main(String[] args) {
        // Create two Time objects using the parameterized constructor
        Time t1 = new Time(2, 45, 50);
        Time t2 = new Time(1, 20, 40);

        System.out.println("Time 1:");
        t1.displayTime();

        System.out.println("Time 2:");
        t2.displayTime();

        // Sum the two Time objects
        Time t3 = t1.sum(t1, t2);

        System.out.println("Sum of Time 1 and Time 2:");
        t3.displayTime();
    }
}