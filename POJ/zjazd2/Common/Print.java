package Common;
public class Print {

    public static void println(String text) {
        System.out.println(text);
    }
    public static void emptyln() {
        System.out.println(" ");
    }
    public static void emptychar() {
        System.out.print(' ');
    }
    public static void print_in_line(String text) {
        System.out.print(text);
    }
    public static String menu_text() {
        return "\nWpisz nr zadania ktore chcesz zobaczyc, lub wpisz \"koniec\" aby zakonczyc dzialanie programu: ";
    }
    public static void error_msg(String text) {
        Print.println("BŁĄD! Kod: " + text);
    }
}
