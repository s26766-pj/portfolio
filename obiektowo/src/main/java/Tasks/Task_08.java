package Tasks;

import Common.Print;
import Common.User;
import Functions.DrawStars;
import java.util.InputMismatchException;

public class Task_08 {
    public static void run_task_08() {
        Print.println("Zadanie 8. Narysuj gwiazdki: ");
        Print.println("Podaj liczbe n: ");
        try {
            DrawStars.draw(User.get_int());
        } catch (NumberFormatException | InputMismatchException e) {
            Print.error_msg("NF-IM");
            run_task_08();
        }
    }
}
