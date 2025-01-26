import java.util.Arrays;

class Array {

    private int[] data;

    public Array() {
        this.data = new int[10];
    }

    public Array(int size) {
        this.data = new int[size];
    }

    public Array(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    public void Reverse_an_array() {
        for (int i = 0; i < data.length / 2; i++) {
            int temp = data[i];
            data[i] = data[data.length - 1 - i];
            data[data.length - 1 - i] = temp;
        }
    }

    public int Maximum_of_array() {
        int max = data[0];
        for (int num : data) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public int Average_of_array() {
        int sum = 0;
        for (int num : data) {
            sum += num;
        }
        return sum / data.length;
    }

    public void Sorting() {
        Arrays.sort(data);
    }

    public void display() {
        System.out.println(Arrays.toString(data));
    }

    public int search(int no) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == no) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return data.length;
    }
}

class Main1{

    public static void main(String[] args) {
        Array arr1 = new Array();
        System.out.println("Default constructor:");
        arr1.display();

        Array arr2 = new Array(5);
        System.out.println("\nConstructor with size 5:");
        arr2.display();

        int[] initialData = {3, 1, 4, 1, 5, 9};
        Array arr3 = new Array(initialData);
        System.out.println("\nConstructor with initialized data:");
        arr3.display();

        System.out.println("\nReversing the array:");
        arr3.Reverse_an_array();
        arr3.display();

        System.out.println("\nMaximum of the array: " + arr3.Maximum_of_array());

        System.out.println("Average of the array: " + arr3.Average_of_array());

        System.out.println("\nSorting the array:");
        arr3.Sorting();
        arr3.display();

        int searchElement = 5;
        int index = arr3.search(searchElement);
        if (index != -1) {
            System.out.println("\nElement " + searchElement + " found at index: " + index);
        } else {
            System.out.println("\nElement " + searchElement + " not found.");
        }
        System.out.println("\nSize of the array: " + arr3.size());
    }
}