package Tasks;

import Common.Print;
import Common.User;
import Functions.Max;

import java.util.InputMismatchException;

public class Task_13 {

    public static void run_task_13() {
        Print.println("Zadanie 13. Znajdź największy element tablicy:");
        Print.println("Największy element = " + Max.findMax(quantity_of_elements(), elements()));
    }
    public static int quantity_of_elements() {
        Print.println("Podaj ilosc elementow tablicy: ");
        int quantity_of_elements = 0;
        try {
            quantity_of_elements = User.get_int();
        } catch (InputMismatchException e) {
            Print.error_msg("IM00");
        }
        return quantity_of_elements;
    }
    public static String[] elements() {
        Print.println("Podaj elementy tablicy: ");
        return User.get_line_and_separate();
    }
}








