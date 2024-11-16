package Functions;

import Common.Print;


public class Matrix {
    private final int a;
    private final int b;
    private final int[][] matrix;

    public Matrix(int a, int b, int[][] matrix) {
        this.a = a;
        this.b = b;
        this.matrix = matrix;
    }
    public void flipMatrix() {
        int[][] flip_matrix = new int[a][b];
        CountDown cd = new CountDown(a);

        for (int w = 0; w < a; w++) {

            int[] values_line = matrix[cd.getInstance()];
            System.arraycopy(values_line, 0, flip_matrix[w], 0, b);

        }
        int i;
        int j;
        Print.emptyln();
        for (i = 0; i < b; i++) {
            for (j = 0; j < a; j++) {
                Print.print_in_line(flip_matrix[i][j] + " ");
            }
            Print.emptyln();
        }

    }


    public void printMatrix() {
        int i;
        int j;
        Print.emptyln();
        for (i = 0; i < b; i++) {
            for (j = 0; j < a; j++) {
                Print.print_in_line(matrix[i][j] + " ");
            }
            Print.emptyln();
        }
    }
}