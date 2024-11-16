package Tasks;

import Common.Print;
import java.text.DecimalFormat;

public class Task_10 {
    public static void run_task_10() {
        Print.println("Zadanie 10. Potęgowanie liczby 2:");

        // uzyskaj wynik w specyficznym formacie bez przecinka

        DecimalFormat specific_format = new DecimalFormat("#");

        // oblicz pootęgi, od 0 do 14

        for ( int i = 0; i <= 14; i++) {
            Print.println("2 do potęgi " + i + " wynosi: " + specific_format.format(Math.pow(2, i)));
        }
    }
}