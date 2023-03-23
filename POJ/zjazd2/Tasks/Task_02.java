package Tasks;

import Common.Print;
import Common.User;
import Functions.Person;

import java.util.InputMismatchException;


public class Task_02 {


    public static void run_task_02() {
        Print.println("Zadanie 2. Pobierz i wyświetl dane od użytkownika:");
        // zbuduj obiekt
        Person p = new Person();
        // wczytaj dane
        Print.println("Podaj imie:");
        p.firstname = User.get_line();
        Print.println("Podaj nazwisko:");
        p.surname = User.get_line();
        Print.println("Podaj numer grupy:");
        // próbuje wczytać grupe jako int
        try {
            p.group = User.get_int();
        } catch (NumberFormatException | InputMismatchException e) {
            Print.error_msg("NF-IM");
            // w przypdaku błędu spróbuje jeszcze raz wczytać int-a
            Print.println("Podaj numer grupy:");
            try {
                p.group = User.get_int();
            } catch (NumberFormatException | InputMismatchException f) {
                Print.error_msg("NF-IM");
            }
        }
        Print.println("Podaj kierunek studiów:");
        p.field = User.get_line();
        // pokaz dane
        Print.println("imie: " + p.getFirstname());
        Print.println("nazwisko: " + p.getSurname());
        Print.println("grupa: " + p.getGroup());
        Print.println("kierunek: " + p.getField());
    }



}