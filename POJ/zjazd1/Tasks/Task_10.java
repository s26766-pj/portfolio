package Tasks;

import Common.Print;
import Common.User;
import Functions.Matrix;



public class Task_10 {
    public static void run_task_10() {
        Print.println("Zadanie 10. Transpozycja macierzy: ");
        Print.println("Podaj ilosc wierszy oraz ilosc kolumn (a b) :");

        try {
            String[] a_and_b = User.get_line_and_separate();
            int a = Integer.parseInt(a_and_b[0]);
            int b = Integer.parseInt(a_and_b[1]);
            int[][] matrix = new int[a][b];

            for (int w = 0; w < a; w++) {
                Print.println("Podaj wartosci dla wiersza nr " + (w + 1) + ":");
                String[] values_line = User.get_line_and_separate();
                for (int k = 0; k < b; k++) {
                    matrix[w][k] = Integer.parseInt(values_line[k]);
                }
            }
            Matrix m = new Matrix(a, b, matrix);
            m.showT();

        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            Print.error_msg("NFE-I00B");
        }
    }
}
