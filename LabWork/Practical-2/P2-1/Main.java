import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Array arr1 = new Array();
        System.out.println("Default Array (size 10): ");
        arr1.display();


        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        Array arr2 = new Array(size);
        arr2.display();


        int[] numbers = new int[] {5, 8, 2, 1, 9};
        Array arr3 = new Array(numbers);
        arr3.display();

        // Reverse the array
        arr3.Reverse_an_array();
        System.out.println("Reversed Array:");
        arr3.display();

        // Find the maximum element
        System.out.println("Maximum Element: " + arr3.Maximum_of_array());

        // Find the average
        System.out.println("Average of Array: " + arr3.Average_of_array());

        // Sort the array
        arr3.Sorting();
        System.out.println("Sorted Array:");
        arr3.display();

        // Search for an element
        System.out.print("Enter a number to search: ");
        int searchValue = scanner.nextInt();
        int index = arr3.search(searchValue);
        if (index != -1) {
            System.out.println(searchValue + " found at index: " + index);
        } else {
            System.out.println(searchValue + " not found in array.");
        }

        // Get the size of the array
        System.out.println("Size of the array: " + arr3.size());

        scanner.close();
    }
}