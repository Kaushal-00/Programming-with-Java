import java.util.Scanner;

class Matrix {
    int row, column;
    float mat[][];

    // Constructor to initialize with a given 2D array
    Matrix(float a[][]) {
        row = a.length;
        column = a[0].length;
        mat = a;
    }

    // Default constructor (creates an empty matrix)
    Matrix() {
        row = 0;
        column = 0;
        mat = new float[0][0];
    }

    // Constructor to create a matrix with given size
    Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        mat = new float[row][column];
    }

    // Function to read a matrix from user input
    void readMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter elements of the matrix (" + row + "x" + column + "):");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                mat[i][j] = scanner.nextFloat();
            }
        }
    }

    // Function to compute the transpose of the matrix
    float[][] transpose() {
        float trans[][] = new float[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                trans[j][i] = mat[i][j];
            }
        }
        return trans;
    }

    // Function to multiply two matrices
    float[][] matrixMultiplication(Matrix second) {
        if (column != second.row) {
            System.out.println("Matrix multiplication is not possible!");
            return new float[0][0];
        }

        float result[][] = new float[row][second.column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < second.column; j++) {
                result[i][j] = 0;
                for (int k = 0; k < column; k++) {
                    result[i][j] += mat[i][k] * second.mat[k][j];
                }
            }
        }
        return result;
    }

    // Function to display a matrix
    void displayMatrix(float a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function to display the current matrix
    void displayMatrix() {
        displayMatrix(mat);
    }

    // Function to find the maximum element in the matrix
    float maximum_of_array() {
        float max = mat[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (mat[i][j] > max)
                    max = mat[i][j];
            }
        }
        return max;
    }

    // Function to find the average of all elements in the matrix
    float average_of_array() {
        float sum = 0;
        int count = row * column;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sum += mat[i][j];
            }
        }
        return sum / count;
    }
}