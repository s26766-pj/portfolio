package Functions;

import Common.Print;
import Common.User;

public class Game {
    private final char letter;
    private boolean gameON;

    public Game(char letter, boolean gameON) {
        this.letter = letter;
        this.gameON= gameON;
    }

    // uruchom gre w pętli

    public void checkLetter() {

        char guess;
        while (gameON) {

            // info dla użytkownika

            Print.println("\nPomyślałem literę z przedziału od A do Z.");
            Print.print_in_line("Odgadnij ją: ");

            // pobierz litere od użytkownika i sprawdź czy litera jest poprawna
            guess = get_guess_from_user();
            if (guess == letter) {
                Print.println("Dobrze!");
                Print.println("Gra zakończona.");

                // zakończ gre gdy użytkownik odgadnie litere

                gameON = false;

            } else if (guess > letter) {
                Print.println("Źle!");
                Print.println("Trafiłeś zbyt wysoko!");
            } else {
                Print.println("Źle!");
                Print.println("Trafiłeś zbyt nisko!");
            }
        }
    }

    // funkcja komunikacji z użytkownikiem

    public char get_guess_from_user() {
        char guess = '0';
        try {
            guess = User.get_line().toUpperCase().charAt(0);
        } catch (IndexOutOfBoundsException e) {
            Print.error_msg("I00B");
        }
        return guess;
    }

}
