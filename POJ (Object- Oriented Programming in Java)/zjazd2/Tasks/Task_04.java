package Tasks;

import Common.Print;
import Common.User;


public class Task_04 {

    public static void run_task_04() {
        Print.println("Zadanie 4. Porównaj dwa stringi:");
        Print.println("Podaj pierwszy String:");
        String str1 = User.get_line();
        Print.println("Podaj drugi String:");
        String str2 = User.get_line();

        Print.println("str1: " + str1);
        Print.println("str2: " + str2);
        // mój intelliJ odradza mi użycia str1==str2
        Print.println("str1 == str2: " + (str1.equals(str2)));

    }
}