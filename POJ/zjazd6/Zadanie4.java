import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Zadanie4 {
    public static void main(String[] args) {
        Map<Integer, String> months = new HashMap<>();
        months.put(1, "Styczeń");
        months.put(2, "Luty");
        months.put(3, "Marzec");
        months.put(4, "Kwiecień");
        months.put(5, "Maj");
        months.put(6, "Czerwiec");
        months.put(7, "Lipiec");
        months.put(8, "Sierpień");
        months.put(9, "Wrzesień");
        months.put(10, "Październik");
        months.put(11, "Listopad");
        months.put(12, "Grudzień");

        Scanner scanner = new Scanner(System.in);
        int numerMiesiaca = 0;

        try {
            System.out.print("Podaj numer miesiąca (1-12): ");
            numerMiesiaca = scanner.nextInt();

            if (numerMiesiaca >= 1 && numerMiesiaca <= 12) {
                String miesiac = months.get(numerMiesiaca);
                System.out.println("Miesiąc o numerze " + numerMiesiaca + " to " + miesiac);
            } else {
                System.out.println("Podano nieprawidłowy numer miesiąca.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Podano nieprawidłowy typ danych.");
        }
        System.out.println("Wszystkie miesiące to: " + months);
    }
}
