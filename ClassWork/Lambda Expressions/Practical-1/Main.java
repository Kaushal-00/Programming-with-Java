import java.util.*;

interface Condition {
    boolean test(int number);
}

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 22, 33, 40, 55, 60);

        Condition isEven = (n) -> n % 2 == 0;  //Take one integer n, and return true if n % 2 == 0, else return false.

        System.out.println("Even numbers:");
        for (int num : numbers) {
            if (isEven.test(num)) {
                System.out.println(num);
            }
        }
    }
}