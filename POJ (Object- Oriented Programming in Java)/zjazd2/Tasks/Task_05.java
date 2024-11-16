package Tasks;

import Common.Print;


public class Task_05 {

    public static void run_task_05() {
        Print.println("Zadanie 5. Pokaż przykłady opeatorów:");

        // a)
        Print.println("a) inkrementacji i dekrementacji:");
        int x = 5;
        int y = 10;
        Print.println("x = " + x);
        Print.println("y = " + y);
        Print.println("++x = " + ++x);
        Print.println("y++ = " + y++);
        Print.println("x = " + x);
        Print.println("y = " + y);

        // b)
        Print.println("\nb) arytmetycznych:");
        double w = 33.5;
        double z = 17.3;
        double sum = w + z;
        double sub = w - z;
        double mul = w * z;
        double div = w / z;
        double mod = w % z;
        Print.println("w = " + w);
        Print.println("z = " + z);
        Print.println("w + z = " + sum);
        Print.println("w - z = " + sub);
        Print.println("w * z = " + mul);
        Print.println("w / z = " + div);
        Print.println("w % z = " + mod);

        // c)
        Print.println("\nc) relacyjnych:");
        int m = 3;
        int n = 17;
        int o = 10;
        Print.println("m < n = " + (m < n));
        Print.println("m > o = " + (m > o));
        Print.println("n ≤ n = " + (n <= o));
        Print.println("m ≥ n = " + (m >= n));
        Print.println("n = o = " + (n == o));
        Print.println("m ≠ o = " + (m != o));
    }
}