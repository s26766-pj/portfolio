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

    public void showT() {
        int i;
        int j;

        Print.println("[A]T = ");
        for (i = 0; i < b; i++) {
            for (j = 0; j < a; j++) {
                Print.print_in_line(matrix[j][i] + " ");
            }
            Print.println(" ");
        }
    }
}
