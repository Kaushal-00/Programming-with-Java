import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            int n;
            System.out.print("Enter number of elements: ");
            n = sc.nextInt();

            if (n == 0) {
                throw new ArithmeticException("n cannot be zero.");
            }

            int[] arr = new int[n];
            int sum = 0;

            for (int i = 0; i < n; i++) {
                System.out.print("Enter positive integer for index " + i + ": ");
                arr[i] = sc.nextInt();

                if (arr[i] < 0) {
                    throw new IllegalArgumentException("Negative value entered at index " + i);
                }

                sum += arr[i];
            }

            double average = (double) sum / n;
            System.out.println("Average: " + average);

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter only integer values.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}