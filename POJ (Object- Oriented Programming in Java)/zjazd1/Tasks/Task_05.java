package Tasks;

import Common.Print;
import Common.User;

import java.util.InputMismatchException;

public class Task_05 {
    public static void run_task_05() {
        Print.println("Zadanie 5. Sprawdź ile miesiąc ma dni: ");
        Print.println("Podaj nr miesiaca (1-12): ");
    int nr_of_months = 12;
    int first = 1;
    int nr_of_days;
    int check_month;

    try {
        check_month = (int) User.get_int();
        if (check_month >= first && check_month <= nr_of_months) {
            switch (check_month) {
                case 1 -> {
                    nr_of_days = 31;
                    Print.println("Styczeń: " + nr_of_days + " dni");
                }
                case 2 -> {
                    nr_of_days = 28;
                    Print.println("Luty: " + nr_of_days + " dni");
                }
                case 3 -> {
                    nr_of_days = 31;
                    Print.println("Marzec: " + nr_of_days + " dni");
                }
                case 4 -> {
                    nr_of_days = 30;
                    Print.println("Kwiecień: " + nr_of_days + " dni");
                }
                case 5 -> {
                    nr_of_days = 31;
                    Print.println("Maj: " + nr_of_days + " dni");
                }
                case 6 -> {
                    nr_of_days = 30;
                    Print.println("Czerwiec: " + nr_of_days + " dni");
                }
                case 7 -> {
                    nr_of_days = 31;
                    Print.println("Lipiec: " + nr_of_days + " dni");
                }
                case 8 -> {
                    nr_of_days = 31;
                    Print.println("Sierpień: " + nr_of_days + " dni");
                }
                case 9 -> {
                    nr_of_days = 30;
                    Print.println("Wrzesień: " + nr_of_days + " dni");
                }
                case 10 -> {
                    nr_of_days = 31;
                    Print.println("Październik: " + nr_of_days + " dni");
                }
                case 11 -> {
                    nr_of_days = 30;
                    Print.println("Listopad: " + nr_of_days + " dni");
                }
                case 12 -> {
                    nr_of_days = 31;
                    Print.println("Grudzień: " + nr_of_days + " dni");
                }
            }
        } else {
            Print.error_msg("Nie ma takiego miesiąca.");
        }
    } catch (InputMismatchException e) {
        Print.error_msg("IME00");
    }
}
}
