import java.util.Arrays;
import java.util.Scanner;

class Array {

    private int data[];

    // Default constructor - Creates an array of size 10
    public Array() {
        // int data = new int[10];
        data = new int[10];
    }

    // Parameterized constructor - Creates an array of given size
    public Array(int size) {
        Scanner scanner = new Scanner(System.in);
        data = new int[size];

        System.out.println("Enter the elements of the Array: ");
        for (int i = 0; i < data.length; i++) {
            data[i] = scanner.nextInt();
        }
    }

    // Constructor that initializes array with given values
    public Array(int data[]) {
        // this.data = data;
        this.data = Arrays.copyOf(data, data.length);
    }

    // Reverse the array
    public void Reverse_an_array() {
        int left = 0, right = data.length - 1;
        while (left < right) {
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
            left++;
            right--;
        }
    }

    // Find the maximum element in the array
    public int Maximum_of_array() {
        int max = data[0];
        for (int num : data) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Find the average of elements in the array
    public int Average_of_array() {
        int sum = 0;
        for (int num : data) {
            sum += num;
        }
        return sum / data.length;
    }

    // Sort the array in ascending order
    public void Sorting() {
        Arrays.sort(data);
    }

    // Display elements of the array
    public void display() {
        System.out.println(Arrays.toString(data));
    }

    // Search for an element and return its index, else return -1
    public int search(int no) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == no) {
                return i;
            }
        }
        return -1;
    }

    // Return the size of the array
    public int size() {
        return data.length;
    }
}