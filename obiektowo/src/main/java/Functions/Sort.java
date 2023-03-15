package Functions;

import java.util.ArrayList;

public class Sort {
    public static ArrayList<Double> run_sort(ArrayList<Double> set_of_numbers, String start_at) {
        for (int i = 1; i < set_of_numbers.size(); i++) {
            double index = set_of_numbers.get(i);
            int j = i;
            if (start_at.equals("max")) {
                while (j > 0 && set_of_numbers.get(j - 1) < index) {
                    set_of_numbers.set(j, set_of_numbers.get(j - 1));
                    j--;
                }
                set_of_numbers.set(j, index);
            } else {
                while (j > 0 && set_of_numbers.get(j - 1) > index) {
                    set_of_numbers.set(j, set_of_numbers.get(j - 1));
                    j--;
                }
                set_of_numbers.set(j, index);

            }

        }
        return set_of_numbers;
    }
}