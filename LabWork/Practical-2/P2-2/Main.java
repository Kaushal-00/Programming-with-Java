import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating first matrix using parameterized constructor
        System.out.print("Enter rows and columns for first matrix: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        Matrix m1 = new Matrix(r1, c1);
        m1.readMatrix();

        // Creating second matrix using parameterized constructor
        System.out.print("Enter rows and columns for second matrix: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        Matrix m2 = new Matrix(r2, c2);
        m2.readMatrix();

        // Displaying first matrix
        System.out.println("First Matrix:");
        m1.displayMatrix();

        // Displaying second matrix
        System.out.println("Second Matrix:");
        m2.displayMatrix();

        // Transpose of first matrix
        System.out.println("Transpose of First Matrix:");
        m1.displayMatrix(m1.transpose());

        // Multiplication of two matrices
        System.out.println("Multiplication of Matrices:");
        m1.displayMatrix(m1.matrixMultiplication(m2));

        // Finding the maximum and average in first matrix
        System.out.println("Maximum element in First Matrix: " + m1.maximum_of_array());
        System.out.println("Average of elements in First Matrix: " + m1.average_of_array());

        sc.close();
    }
}
