package Tasks;

import Common.Print;
import Common.User;
import Functions.Palindrome;

public class Task_09 {

    public static void run_task_09() {
        Print.println("Zadanie 9:");
        Print.println("Podaj slowo aby sprawdzic czy jest palindromem:");

        String word = User.get_line().toLowerCase();

        // nie rozumiem tego zadania
        // aczkolwiek postaram sie jak moge
        // wywoluje tablice char

        char[] char_array = word.toCharArray();

        // zapisuje wartosc slowa do tablicy char
        // wywoluje funkcje sprawdzajaca slowo, przekazujac tablice znakow char

        if (Palindrome.check_word(char_array)) {
            Print.println("TAK");
        } else {
            Print.println("NIE");
        }
    }


}
