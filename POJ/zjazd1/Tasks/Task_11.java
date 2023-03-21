package Tasks;

import Common.Print;
import Common.User;
import Functions.Pangram;

public class Task_11 {
    public static void run_task_11() {
        Print.println("Zadanie 11. Sprawdź czy zdanie jest pangramem:");
        Print.println("Podaj zdanie do sprawdzenia: ");
        Print.println(String.valueOf(Pangram.getResult(User.get_line())));
    }
}


