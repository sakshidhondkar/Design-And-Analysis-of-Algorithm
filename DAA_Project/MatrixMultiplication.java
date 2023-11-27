package DAA_Project;

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input dimensions of matrix A
        System.out.print("Enter the number of rows for matrix A: ");
        int m = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix A: ");
        int n = scanner.nextInt();

        // Input dimensions of matrix B
        System.out.print("Enter the number of rows for matrix B: ");
        int p = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix B: ");
        int q = scanner.nextInt();

        // Check if matrix multiplication is possible
        if (n != p) {
            System.out.println("Matrix multiplication is not possible. Column count of A must be equal to row count of B.");
            return;
        }

        // Initialize matrices A and B
        int[][] A = new int[m][n];
        int[][] B = new int[p][q];

        // Input elements of matrix A
        System.out.println("Enter elements of matrix A:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                A[i][j] = scanner.nextInt();
            }
        }

        // Input elements of matrix B
        System.out.println("Enter elements of matrix B:");
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                System.out.print("B[" + i + "][" + j + "]: ");
                B[i][j] = scanner.nextInt();
            }
        }

        // Perform matrix multiplication
        int[][] result = multiply(A, B);

        // Print the result
        System.out.println("Matrix Multiplication Result:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < q; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int q = B[0].length;
        int[][] result = new int[m][q];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < q; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }
}
