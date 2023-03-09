import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean koniec = false;
        while (!koniec) {
            drukuj("""

                    Napisz "koniec" aby zakonczyc dzialanie programu,
                    lub wpisz nr zadania ktore chcesz zobaczyc:""");
            String wczytaj_operacje = pobierz_tekst();
            switch (wczytaj_operacje) {
                case "koniec" -> koniec = true;
                case "1" -> zadanie_01();
                case "2" -> zadanie_02();
                case "3" -> zadanie_03();
                case "4" -> zadanie_04();
                case "5" -> zadanie_05();
                case "6" -> zadanie_06();
                case "7" -> zadanie_07();
                case "8" -> zadanie_08();
                case "9" -> zadanie_09();
                case "10" -> zadanie_10();
                case "11" -> zadanie_11();
                case "12" -> zadanie_12();
                case "13" -> zadanie_13();
            }
        }
    }
    public static void blad() {
        System.out.println("BŁĄD: Podano niewlasciwe dane!");
    }
    public static void drukuj(String text) {
        System.out.println(text);
    }
    public static void drukuj_linje(String text) {
        System.out.print(text + ' ');
    }
    public static ArrayList<String> pobierz_liczby() {
        Scanner scan = new Scanner(System.in);
        String wczytaj_liczby = scan.nextLine();
        String[] liczby = wczytaj_liczby.split(" ");
        return new ArrayList<>(Arrays.asList(liczby));
    }
    public static String pobierz_tekst() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    public static int pobierz_liczbe_naturalna() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
    
    
    
    // -= > Z A D A N I E -=> 1 :
    
    
    
    public static void zadanie_01() {
        drukuj("\nZadanie 1:");
        try {
            Scanner scan = new Scanner(System.in);
            drukuj("Podaj bok a: ");
            float bok_a = scan.nextFloat();
            drukuj("Podaj bok b: ");
            float bok_b = scan.nextFloat();
            float pole_prostokata = bok_a * bok_b;
            drukuj("Pole prostokata wynosi: ");
            drukuj(bok_a + " * " + bok_b + " = " + pole_prostokata);
        } catch (InputMismatchException e) {
            blad();
        }
    }
    public static double zaokraglanie(double wartosc) {
        int precyzja = 2;
        BigDecimal bigDecimal = new BigDecimal(wartosc);
        bigDecimal = bigDecimal.setScale(precyzja, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
    
    
    
    // -= > Z A D A N I E -=> 2 :
    
    
    
    public static void zadanie_02() {
        drukuj("\nZadanie 2:");
        String znak_pi = "π";
        String znak_pierwiastek = "√";
        double liczba_pi = Math.PI;
        double pierwiastek = zaokraglanie(Math.sqrt(liczba_pi));
        drukuj(znak_pierwiastek + znak_pi + " = " + pierwiastek);
    }
        
        
        
    // -= > Z A D A N I E -=> 3 :
    
    
    
    public static void zadanie_03() {
        drukuj("\nZadanie 3:");
        drukuj("Podaj tekst:");
        try {
            String wczytaj_tekst = pobierz_tekst();
            String[] slowa = wczytaj_tekst.split(" ");
            String napis_koncowy = "\"%" + slowa[1] + " " + slowa[0] + "%\"";
            drukuj(napis_koncowy);
        } catch (ArrayIndexOutOfBoundsException e) {
            blad();
        }
    }
        
        
        
    // -= > Z A D A N I E -=> 4 :
    
    
    
    public static void zadanie_04() {
        drukuj("\nZadanie 4:");
        drukuj("Podaj boki trojkata (a b c): ");
        try {
            String wczytaj_boki = String.valueOf(pobierz_liczby());
            String[] boki = wczytaj_boki.split(" ");
            float bok_a = Float.parseFloat(boki[0]);
            float bok_b = Float.parseFloat(boki[1]);
            float bok_c = Float.parseFloat(boki[2]);
            String status_abc = "oceniam";
            if (bok_a > 0 && bok_b > 0 && bok_c > 0) {
                status_abc = "OK";
            } else {
                drukuj("BŁĄD");
                zadanie_04();
            }
            if (status_abc.equals("OK")) {
                if (bok_a + bok_b > bok_c && bok_a + bok_c > bok_b && bok_b + bok_c > bok_a) {
                    drukuj("TAK");
                } else {
                    drukuj("NIE");
                }
            }


        } catch (InputMismatchException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            blad();
            zadanie_04();
        }
    }
            
            
        
    // -= > Z A D A N I E -=> 5 :
    
    
    
    public static void zadanie_05() {
        drukuj("\nZadanie 5:");
        drukuj("Podaj nr miesiaca: ");
        int liczba_miesiecy = 12;
        int pierwszy_miesiac = 1;
        int styczen = 31;
        int luty = 28;
        int marzec = 31;
        int kwiecien = 30;
        int maj = 31;
        int czerwiec = 30;
        int lipiec = 31;
        int sierpien = 31;
        int wrzesien = 30;
        int pazdziernik = 31;
        int listopad = 30;
        int grudzien = 31;
        try {
            int wczytaj_miesiac = pobierz_liczbe_naturalna();
            if (wczytaj_miesiac >= pierwszy_miesiac && wczytaj_miesiac <= liczba_miesiecy) {
                switch (wczytaj_miesiac) {
                    case 1 -> drukuj("Styczeń: " + styczen + " dni");
                    case 2 -> drukuj("Luty: " + luty + " dni");
                    case 3 -> drukuj("Marzec: " + marzec + " dni");
                    case 4 -> drukuj("Kwiecień: " + kwiecien + " dni");
                    case 5 -> drukuj("Maj: " + maj + " dni");
                    case 6 -> drukuj("Czerwiec: " + czerwiec + " dni");
                    case 7 -> drukuj("Lipiec: " + lipiec + " dni");
                    case 8 -> drukuj("Sierpień: " + sierpien + " dni");
                    case 9 -> drukuj("Wrzesień: " + wrzesien + " dni");
                    case 10 -> drukuj("Październik: " + pazdziernik + " dni");
                    case 11 -> drukuj("Listopad: " + listopad + " dni");
                    case 12 -> drukuj("Grudzień: " + grudzien + " dni");
                }
            } else {
                drukuj("BŁĄD");
                zadanie_05();
            }
        } catch (InputMismatchException e) {
            blad();
            zadanie_04();
        }
    }
    public static void sortuj(ArrayList<Double> zbior_liczb) {
        for (int i = 1; i < zbior_liczb.size(); i++) {
            double index = zbior_liczb.get(i);
            int j = i;
            while (j > 0 && zbior_liczb.get(j - 1) < index) {
                zbior_liczb.set(j, zbior_liczb.get(j - 1));
                j--;
            }
            zbior_liczb.set(j, index);
        }
    }
            
    
        
    // -= > Z A D A N I E -=> 6 :
    
    
    
    public static void zadanie_06() {
        drukuj("\nZadanie 6:");
        drukuj("Podaj liczby do sortowania (1 2 3 itd.): ");
        try {
            String[] liczby_do_sortowania = pobierz_liczby().toArray(new String[0]);
            ArrayList<Double> zbior_liczb = new ArrayList<>();
            for (String s : liczby_do_sortowania) {
                zbior_liczb.add(Double.valueOf(s));
            }
            // uzyskaj specyficzny format liczby
            DecimalFormat specyficzny_format = new DecimalFormat("#.000000");
            sortuj(zbior_liczb);
            for (Double aDouble : zbior_liczb) {
                drukuj_linje(specyficzny_format.format(aDouble));
            }
            drukuj(" ");
        } catch (NumberFormatException e) {
            blad();
        }
    }
    
    
    
    // -= > Z A D A N I E -=> 7 :
    
    
    
    public static void zadanie_07() {
        drukuj("\nZadanie 7:");
        drukuj("Podaj dwie liczby naturalne (m n): ");
        ArrayList<Integer> tablica_01 = new ArrayList<>();
        ArrayList<Integer> tablica_02 = new ArrayList<>();
        int liczba_m;
        int liczba_n;
        int wyznacznik_i;
        int iloczyn_skalarny = 0;
        try {
            ArrayList<String> liczby_do_sortowania = pobierz_liczby();
            liczba_m = Integer.parseInt(liczby_do_sortowania.get(0));
            liczba_n = Integer.parseInt(liczby_do_sortowania.get(1));
            if (liczba_m > liczba_n) {
                wyznacznik_i = liczba_m;
                int roznica_m_i_n = liczba_m - liczba_n;
                for (int i = 1; i <= liczba_m; i++) {
                    tablica_01.add(i);
                }
                for (int i = 1; i <= liczba_n; i++) {
                    tablica_02.add(i);
                }
                for (int i = 1; i <= roznica_m_i_n; i++) {
                    tablica_02.add(0);
                }
                for (int i = 0; i < liczba_m; i++) {
                    drukuj_linje(String.valueOf(tablica_01.get(i)));
                    drukuj_linje(String.valueOf(tablica_02.get(i)));
                    drukuj(" ");
                }
            } else if (liczba_m < liczba_n) {
                wyznacznik_i = liczba_n;
                int roznica_m_i_n = liczba_n - liczba_m;
                for (int i = 1; i <= liczba_m; i++) {
                    tablica_01.add(i);
                }
                for (int i = 1; i <= roznica_m_i_n; i++) {
                    tablica_01.add(0);
                }
                for (int i = 1; i <= liczba_n; i++) {
                    tablica_02.add(i);
                }
                for (int i = 0; i < liczba_n; i++) {
                    drukuj_linje(String.valueOf(tablica_01.get(i)));
                    drukuj_linje(String.valueOf(tablica_02.get(i)));
                    drukuj(" ");
                }
            } else {
                wyznacznik_i = liczba_m;
                for (int i = 1; i <= liczba_m; i++) {
                    tablica_01.add(i);
                    drukuj(i + " " + i);
                }
                for (int i = 1; i <= liczba_n; i++) {
                    tablica_02.add(i);
                }
            }
            if (liczba_m != liczba_n) {
                drukuj("UWAGA! Program wyrownal wymiary wektorow dodajac liczbe zero.");
            }
            for (int i = 0; i < wyznacznik_i; i++) {
                iloczyn_skalarny += tablica_01.get(i) * tablica_02.get(i);
            }
            drukuj("Iloczyn skalarny wektorow: ");
            drukuj(String.valueOf(iloczyn_skalarny));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            blad();
        }
    }
    public static void rysuj_spacje_malejaco(int matryca) {
        int liczba_gwiazdek = 1;
        int liczba_spacji = matryca;
        while (liczba_gwiazdek != matryca + 1) {
            for (int i = 1; i < liczba_spacji; i++) {
                drukuj_linje(" ");
            }
            for (int j = liczba_gwiazdek; j != 0; j--) {
                drukuj_linje("*");
            }
            drukuj(" ");
            liczba_gwiazdek += 1;
            liczba_spacji -= 1;
        }
        drukuj(" ");
    }
    public static void rysuj_spacje_rosnaco(int matryca) {
        int liczba_gwiazdek = matryca;
        int liczba_spacji = 0;
        while (liczba_spacji != matryca) {
            for (int j = 0; j < liczba_spacji; j++) {
                drukuj_linje(" ");
            }
            for (int i = 0; i < liczba_gwiazdek; i++) {
                drukuj_linje("*");
            }
            drukuj(" ");
            liczba_spacji += 1;
            liczba_gwiazdek -= 1;
        }
    }
    public static void rysuj_gwiazdki_rosnaco(int matryca) {
        for (int i = 1; i <= matryca; i++) {
            for (int j = 1; j <= i; j++) {
                drukuj_linje("*");
            }
            drukuj(" ");
        }
    }
    public static void rysuj_gwiazdki_malejaco(int matryca) {
        for (int i = matryca; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                drukuj_linje("*");
            }
            drukuj(" ");
        }
    }
    public static void rysuj_gwiazdki(int matryca) {
        rysuj_gwiazdki_rosnaco(matryca);
        rysuj_gwiazdki_malejaco(matryca);
        rysuj_spacje_rosnaco(matryca);
        rysuj_spacje_malejaco(matryca);
    }
    
    
    
    // -= > Z A D A N I E -=> 8 :
    
    
    
    public static void zadanie_08() {
        drukuj("\nZadanie 8:");
        drukuj("Podaj liczbe n: ");
        Scanner scan = new Scanner(System.in);
        try {
            int liczba_n = scan.nextInt();
            rysuj_gwiazdki(liczba_n);
        } catch (NumberFormatException | InputMismatchException e) {
            blad();
            zadanie_08();
        }
    }
    public static boolean sprawdz_czy_slowo_jest_palindromem(char[] tablica_char) {
        // tworze string ze slowem zapisanym na wspak
        StringBuilder slowo_od_tylu = new StringBuilder();
        for (int i = tablica_char.length - 1; i >= 0; i--) {
            slowo_od_tylu.append(tablica_char[i]);
        }
        // tworze tablice char ze slowem zapisanym na wspak
        char[] tablica_znakow_zapisana_od_tylu = slowo_od_tylu.toString().toCharArray();
        // sprawdzam czy dwie tablice sa takie same
        return Arrays.equals(tablica_char, tablica_znakow_zapisana_od_tylu);
    }
    
    
    
    // -= > Z A D A N I E -=> 9 :
    
    
    
    public static void zadanie_09() {
        drukuj("\nZadanie 9:");
        drukuj("Podaj slowo aby sprawdzic czy jest palindromem:");
        Scanner scan = new Scanner(System.in);
        String slowo = scan.nextLine().toLowerCase();

        // nie rozumiem tego zadania
        // aczkolwiek postaram sie jak moge

        // wywoluje tablice char
        char[] tablica_znakow;
        // zapisuje wartosc slowa do tablicy char
        tablica_znakow = slowo.toCharArray();
        // wywoluje funkcje sprawdzajaca slowo, przekazujac tablice znakow char
        if (sprawdz_czy_slowo_jest_palindromem(tablica_znakow)) {
            drukuj("TAK");
        } else {
            drukuj("NIE");
        }
    }
    
    
    
    // -= > Z A D A N I E -=> 10 :
    
    
    
    public static void zadanie_10() {
        drukuj("\nZadanie 10:");
        drukuj("Podaj ilosc wierszy oraz ilosc kolumn (a b) :");
        try {
        ArrayList<String> liczby_a_i_b = pobierz_liczby();
        int liczba_a = Integer.parseInt(liczby_a_i_b.get(0));
        int liczba_b = Integer.parseInt(liczby_a_i_b.get(1));
        int i;
        int j;
            int[][] macierz = new int[liczba_a][liczba_b];
            for (int w = 0; w < liczba_a; w++) {
                drukuj("Podaj wartosci dla wiersza nr " + (w + 1) + ":");
                ArrayList<String> wiersz_wartosci = pobierz_liczby();
                for (int k = 0; k < liczba_b; k++) {
                    macierz[w][k] = Integer.parseInt(wiersz_wartosci.get(k));
                }
            }
            drukuj("[A] = ");
            for (i = 0; i < liczba_a; i++) {
                for (j = 0; j < liczba_b; j++) {
                    drukuj_linje(macierz[i][j] + " ");
                }
                drukuj(" ");
            }
            drukuj("[A]T = ");
            for (i = 0; i < liczba_b; i++) {
                for (j = 0; j < liczba_a; j++) {
                    drukuj_linje(macierz[j][i] + " ");
                }
                drukuj(" ");
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            blad();
        }
    }
    public static boolean sprawdz_pangram(char[] lista_znakow) {
        String alfabet_en_ciag = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alfabet_en = alfabet_en_ciag.toUpperCase().toCharArray();
        return Arrays.equals(alfabet_en, lista_znakow);
    }
    static char[] usun_powtorzenia(char[] str, int length)
    {
        int index = 0;
        for (int i = 0; i < length; i++) {

            // sprawdz czy str[i] byl juz obecny czy nie

            int j;
            for (j = 0; j < i; j++) {
                if (str[i] == str[j]) {
                    break;
                }
            }
            if (j == i) {
                str[index++] = str[i];
            }
        }
        return String.valueOf(Arrays.copyOf(str, index)).toCharArray();
    }
    
    
    
    // -= > Z A D A N I E -=> 11 :
    
    
    
    
    public static void zadanie_11() {
        drukuj("\nZadanie 11:");
        drukuj("Podaj zdanie do sprawdzenia: ");
        String zdanie_do_sprawdzenia = pobierz_tekst().toUpperCase().trim().replaceAll("\\s","");
        List<Character> lista_znakow = new ArrayList<>();
        for (char ch : zdanie_do_sprawdzenia.toCharArray()) {
            lista_znakow.add(ch);
        }
        Collections.sort(lista_znakow);
        StringBuilder lista_char = new StringBuilder();
        for (Character character : lista_znakow) {
            lista_char.append(character);
        }
        char[] posortowane_slowo_zapisane_w_tablicy_char = lista_char.toString().toCharArray();
        int n = posortowane_slowo_zapisane_w_tablicy_char.length;
        drukuj(String.valueOf(sprawdz_pangram(usun_powtorzenia(posortowane_slowo_zapisane_w_tablicy_char, n))));
    }
    public static double ziemia_kontra(double liczba_sekund, double wartosc) {
        double rok_ziemski = 31557600;
        double lat_ziemskich = liczba_sekund / rok_ziemski;
        return lat_ziemskich / wartosc;
    }
    
    
    
    // -= > Z A D A N I E -=> 12 :
    
    
    
    public static void zadanie_12() {
        drukuj("\nZadanie 12:");
        drukuj("Podaj liczbe sekund: ");
        try {
            double liczba_sekund = Double.parseDouble(pobierz_tekst());
            drukuj("Podaj planete: ");
            String na_planecie = pobierz_tekst().toLowerCase();
            String planeta = "planeta";
            double wartosc = 0;
            double wartosc_merkury = 0.2408467;
            double wartosc_wenus = 0.61519726;
            double wartosc_ziemia = 1;
            double wartosc_mars = 1.8808158;
            double wartosc_jowisz = 11.862615;
            double wartosc_saturn = 29.447498;
            double wartosc_uran = 84.016846;
            double wartosc_neptun = 164.79132;
            double wartosc_pluton = 247;
            switch (na_planecie) {
                case "merkury" -> {
                    planeta = "merkury";
                    wartosc = wartosc_merkury;
                }
                case "wenus" -> {
                    planeta = "wenus";
                    wartosc = wartosc_wenus;
                }
                case "ziemia" -> {
                    planeta = "ziemia";
                    wartosc = wartosc_ziemia;
                }
                case "mars" -> {
                    planeta = "mars";
                    wartosc = wartosc_mars;
                }
                case "jowisz" -> {
                    planeta = "jowisz";
                    wartosc = wartosc_jowisz;
                }
                case "saturn" -> {
                    planeta = "saturn";
                    wartosc = wartosc_saturn;
                }
                case "uran" -> {
                    planeta = "uran";
                    wartosc = wartosc_uran;
                }
                case "neptun" -> {
                    planeta = "neptun";
                    wartosc = wartosc_neptun;
                }
                case "pluton" -> {
                    planeta = "pluton";
                    wartosc = wartosc_pluton;
                }
            }
            if (planeta.equals("planeta")) {
                blad();
            }
            drukuj("wynik (lat) = " + zaokraglanie(ziemia_kontra(liczba_sekund, wartosc)));
        } catch (NumberFormatException e) {
            blad();
        }
    }   
    
    
    
    // -= > Z A D A N I E -=> 13 :
    
    
    
    public static void zadanie_13() {
        drukuj("\nZadanie 13:");
        drukuj("Podaj liczbe elementow: ");
        try {
        int liczba_elementow = pobierz_liczbe_naturalna();
        if (liczba_elementow <= 0) {
            blad();
        }
        drukuj("Podaj elementy (liczba elementow = " + liczba_elementow + "): ");
        ArrayList<String> wiersz_wartosci = pobierz_liczby();
        ArrayList<Double> zbior_elementow = new ArrayList<>();
        for (int i = 0; i < liczba_elementow; i++ ) {
            zbior_elementow.add(Double.valueOf(wiersz_wartosci.get(i)));
        }
        sortuj(zbior_elementow);
        int najwiekszy_element = zbior_elementow.get(0).intValue();
        drukuj("Najwiekszy element to: " + najwiekszy_element);
        } catch (InputMismatchException | IndexOutOfBoundsException e) {
            blad();
        }
    }
}
