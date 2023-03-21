package Tasks;

import Common.Print;
import Common.User;

import java.util.InputMismatchException;

public class Task_04 {
    public static void run_task_04() {
        Print.println("Zadanie 4. Czy da się zbudować trójkąt: ");
        Print.println("Podaj boki trójkąta (a b c): ");
        try {
            String[] sides = User.get_line_and_separate();
            float side_a = Float.parseFloat(sides[0]);
            float side_b = Float.parseFloat(sides[1]);
            float side_c = Float.parseFloat(sides[2]);
            int check_3_sides = 3;
            int sides_passed = 0;

            if (side_a > 0) {
                sides_passed++;
            }
            if (side_b > 0) {
                sides_passed++;
            }
            if (side_c > 0) {
                sides_passed++;
            }
            if (sides_passed != check_3_sides) {
                Print.error_msg("Wartości muszą być większe od zera");
            } else {
                if (side_a + side_b > side_c && side_a + side_c > side_b && side_b + side_c > side_b) {
                    Print.println("TAK");
                } else {
                    Print.println("NIE");
                }
            }

        } catch (InputMismatchException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            Print.error_msg("IME-NFE-AI00B");
        }
    }



}
