package Tasks;

import Common.Print;
import Common.User;
import Functions.Convert;
import Functions.Round;

import java.util.InputMismatchException;

public class Task_12 {

    public static void run_task_12() {
        Print.println("Zadanie 12. Lata na innych planetach:");
        Print.println(("Podaj liczbe sekund: "));
        try {
            double liczba_sekund = User.get_double();
            Print.println(("Podaj planete: "));
            Convert c = new Convert(User.get_line().toLowerCase(), liczba_sekund);
            Print.println("wynik (lat) = " + Round.getRound(c.getYears(), 2));
        } catch (NumberFormatException | InputMismatchException e) {
            Print.error_msg("NF00IM00");
        }
    }
}
