package Tasks;

import Common.Print;
import Common.User;
import Functions.Sort;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Task_06 {
    public static void run_task_06() {
        Print.println("Zadanie 6. Sortuj liczby w specyficznym formacie:");
        Print.println("Podaj liczby do sortowania (1 2 3 itd.): ");
        try {
            ArrayList<Double> set_of_numbers = new ArrayList<>();
            for (String s : User.get_line_and_separate()) {
                set_of_numbers.add(Double.valueOf(s));
                }
        DecimalFormat specific_format = new DecimalFormat("#.000000");
        Sort.run_sort(set_of_numbers, "min");
        for (Double aDouble : set_of_numbers) {
            Print.print_in_line(specific_format.format(aDouble) + " ");
        }
        Print.println(" ");
        Sort.run_sort(set_of_numbers, "max");
        for (Double aDouble : set_of_numbers) {
            Print.print_in_line(specific_format.format(aDouble) + " ");
        }
        Print.println(" ");
        } catch (NumberFormatException e) {
            Print.error_msg("NFE000");
        }
        }
    }