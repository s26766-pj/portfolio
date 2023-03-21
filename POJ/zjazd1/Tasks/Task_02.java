package Tasks;

import Common.Print;
import Functions.Round;
import Functions.SquareRoot;

public class Task_02 {
    public static void run_task_02() {
        Print.println("Zadanie 2. Pierwiastek z liczby Pi, zaokrąglony do dwóch miejsc po przecinku:");
        String pi_symbol = "π";
        String square_root_symbol = "√";
        double pi_value = Math.PI;
        SquareRoot s = new SquareRoot(pi_value);
        int round_precision = 2;
        Print.println(square_root_symbol + pi_symbol + " = " + Round.getRound(s.getSquareRoot(), round_precision));
    }
}

