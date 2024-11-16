package Tasks;

import Common.Print;
import Common.User;
import Functions.Matrix;
import java.util.Arrays;


public class Task_06 {
    public static void run_task_06() {
        Print.println("Zadanie 6. Zamiana wierszy macierzy: ");

        int a = 3;
        int b = 3;
        int[][] matrix = new int[a][b];

        try {

            for (int w = 0; w < a; w++) {
                Print.println("Podaj wartosci dla wiersza nr " + (w + 1) + ":");
                String[] values_line = User.get_line_and_separate();
                for (int k = 0; k < b; k++) {
                    matrix[w][k] = Integer.parseInt(values_line[k]);
                }
            }
            Matrix m = new Matrix(a, b, matrix);
            m.printMatrix();
            m.flipMatrix();

        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            Print.error_msg("NFE-I00B");
        }
    }
}