package Tasks;

import Common.Print;
import Functions.Game;


public class Task_09 {
    public static void run_task_09() {
        Print.println("Zadanie 9. Gra - od A do Z:");

        // liczba możliwych liter do wylosowania

        int number_of_all_letters_in_english = 26;

        // wylosuj literę

        char letter = (char) ('A' + (int) (Math.random() * number_of_all_letters_in_english));

        // rozpocznij gre

        Game g = new Game(letter, true);
        g.checkLetter();
    }
}