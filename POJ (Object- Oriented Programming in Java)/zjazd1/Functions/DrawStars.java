package Functions;

import Common.Print;

public class DrawStars {

    public static void rysuj_spacje_malejaco(int pattern) {
        int liczba_gwiazdek = 1;
        int liczba_spacji = pattern;
        while (liczba_gwiazdek != pattern + 1) {
            for (int i = 1; i < liczba_spacji; i++) {
                Print.emptychar();
            }
            for (int j = liczba_gwiazdek; j != 0; j--) {
                Print.print_in_line("*");
            }
            Print.emptyln();
            liczba_gwiazdek += 1;
            liczba_spacji -= 1;
        }
        Print.emptyln();
    }
    public static void rysuj_spacje_rosnaco(int pattern) {
        int liczba_gwiazdek = pattern;
        int liczba_spacji = 0;
        while (liczba_spacji != pattern) {
            for (int j = 0; j < liczba_spacji; j++) {
                Print.emptychar();
            }
            for (int i = 0; i < liczba_gwiazdek; i++) {
                Print.print_in_line("*");
            }
            Print.emptyln();
            liczba_spacji += 1;
            liczba_gwiazdek -= 1;
        }
    }
    public static void rysuj_gwiazdki_rosnaco(int pattern) {
        for (int i = 1; i <= pattern; i++) {
            for (int j = 1; j <= i; j++) {
                Print.print_in_line("*");
            }
            Print.emptyln();
        }
    }
    public static void rysuj_gwiazdki_malejaco(int pattern) {
        for (int i = pattern; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                Print.print_in_line("*");
            }
            Print.emptyln();
        }
    }
    public static void draw(int pattern) {
        rysuj_gwiazdki_rosnaco(pattern);
        rysuj_gwiazdki_malejaco(pattern);
        rysuj_spacje_rosnaco(pattern);
        rysuj_spacje_malejaco(pattern);
    }
}
