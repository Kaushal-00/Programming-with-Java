import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of terms for Fibonacci series: ");
        int terms = scanner.nextInt();

        int num1 = 0, num2 = 1;

        System.out.println("Fibonacci series up to " + terms + " terms:");

        for (int i = 1; i <= terms; i++) {
            System.out.print(num1 + " ");

            int nextTerm = num1 + num2;
            num1 = num2;
            num2 = nextTerm;
        }

        scanner.close();
    }
}
