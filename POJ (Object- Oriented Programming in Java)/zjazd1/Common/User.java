package Common;
import java.util.Scanner;

public class User {
    public static double get_double() {
        Scanner scan = new Scanner(System.in);
        return scan.nextDouble();
    }
    public static float get_float() {
        Scanner scan = new Scanner(System.in);
        return scan.nextFloat();
    }
    public static int get_int() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static String[] get_line_and_separate() {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        return line.split(" ");
    }

    public static String get_line() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
