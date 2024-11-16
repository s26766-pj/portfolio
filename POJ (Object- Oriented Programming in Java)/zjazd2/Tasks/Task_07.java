package Tasks;

import Common.Print;
import Common.User;
import Functions.Cylinder;
import Functions.Round;

import java.util.InputMismatchException;

public class Task_07 {
    public static void run_task_07() {
        Print.println("Zadanie 7. Objętość walca: ");
        double r;
        double h;
        try {
            Print.println("Podaj promień walca:");
            r = User.get_double();
            Print.println("Podaj wysokość walca:");
            h = User.get_double();
            Cylinder c = new Cylinder(r, h);
            Print.println("Pojemność walca wynosi " + Round.getRound(c.getVolume(), 2));
        } catch (InputMismatchException e) {
            Print.error_msg("IME000");
        }
    }
}
