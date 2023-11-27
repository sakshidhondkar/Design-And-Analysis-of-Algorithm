package DAA_Project;

 
public class Multithread {
    public static int[][] multiply(int[][] A, int[][] B, int numThreads) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;
        int[][] result = new int[m][p];

        Thread[] threads = new Thread[numThreads];
        int rowsPerThread = m / numThreads;

        for (int i = 0; i < numThreads; i++) {
            final int startRow = i * rowsPerThread;
            final int endRow = i == numThreads - 1 ? m : (i + 1) * rowsPerThread;
            threads[i] = new Thread(() -> {
                for (int row = startRow; row < endRow; row++) {
                    for (int j = 0; j < p; j++) {
                        for (int k = 0; k < n; k++) {
                            result[row][j] += A[row][k] * B[k][j];
                        }
                    }
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example matrices A and B
        int[][] A = {
            {1, 2},
            {3, 4}
        };

        int[][] B = {
            {5, 6},
            {7, 8}
        };

        int numThreads = 2; // Number of threads for parallel processing

        int[][] result = multiply(A, B, numThreads);

        // Print the result
        System.out.println("Matrix Multiplication:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

