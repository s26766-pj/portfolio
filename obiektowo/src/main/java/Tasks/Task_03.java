package Tasks;

import Common.User;
import Common.Print;

public class Task_03 {
    public static void run_task_03() {
        Print.println("Zadanie 3. Wyświetl ciąg tekstowy w specyficznym formacie: ");
        Print.println("Podaj tekst:");
        try {
            String[] final_line = User.get_line_and_separate();
            Print.println("\"%" + final_line[1] + " " + final_line[0] + "%\"");
        } catch (ArrayIndexOutOfBoundsException e) {
            Print.error_msg("AI00B");
        }
    }
}
