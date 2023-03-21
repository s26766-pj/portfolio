package Tasks;

import Common.Print;
import Common.User;
import Functions.Scalar;
import java.util.InputMismatchException;

public class Task_07 {

    public static void run_task_07() {
        Print.println("Zadanie 7. Iloczyn skalarny wektorów: ");
        Print.println("Podaj wielkosci wektorow, liczby n i m (n m): ");

        try {

            String[] n_and_m = User.get_line_and_separate();
            int n = Integer.parseInt(n_and_m[0]);
            int m = Integer.parseInt(n_and_m[1]);
            int max_size = Math.max(m, n);
            String[] vector1;
            String[] vector2;
            Print.println("Podaj wartosci pierwszego wektora: ");
            vector1 = User.get_line_and_separate();
            Print.println("Podaj wartosci drugiego wektora: ");
            vector2 = User.get_line_and_separate();
            Scalar s = new Scalar(max_size, n, m, vector1, vector2);
            Print.println("Iloczyn skalarny = " + s.getProduct());

        } catch (InputMismatchException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            Print.error_msg("IM-AI00B-NF");
        }
    }
}
