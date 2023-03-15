package Functions;

import java.util.Arrays;

public class Palindrome {


    private final char[] characters_table;
    public Palindrome(char[] charactersTable) {
        this.characters_table = charactersTable;


    }
    public static boolean check_word(char[] tablica_char) {
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
}
