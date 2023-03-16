package Functions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pangram {

    public static char[] Pangram_build(String zdanie_do_sprawdzenia) {

        String fix_case = zdanie_do_sprawdzenia.toUpperCase().trim().replaceAll("\\s","");
        List<Character> lista_znakow = new ArrayList<>();
        for (char ch : fix_case.toCharArray()) {
            lista_znakow.add(ch);
        }
        Collections.sort(lista_znakow);
        StringBuilder lista_char = new StringBuilder();
        for (Character character : lista_znakow) {
            lista_char.append(character);
        }
        char[] posortowane_slowo_zapisane_w_tablicy_char = lista_char.toString().toCharArray();
        int n = posortowane_slowo_zapisane_w_tablicy_char.length;
        return usun_powtorzenia(posortowane_slowo_zapisane_w_tablicy_char, n);
    }

    public static boolean getResult(String zdanie_do_sprawdzenia) {

        String alfabet_en_ciag = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alfabet_en = alfabet_en_ciag.toUpperCase().toCharArray();
        return Arrays.equals(alfabet_en, Pangram_build(zdanie_do_sprawdzenia));
    }
    static char[] usun_powtorzenia(char[] str, int length)
    {
        int index = 0;
        for (int i = 0; i < length; i++) {

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
}
