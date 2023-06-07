import java.util.HashSet;

public class Zadanie2 {
    public static void main(String[] args) {

        HashSet<String> colours = new HashSet<>();

        // Wypełnianie zbioru wartościami

        colours.add("Czerwony");
        colours.add("Pomarańczowy");
        colours.add("Żółty");
        colours.add("Zielony");
        colours.add("Niebieski");
        colours.add("Indygo");
        colours.add("Fioletowy");
        colours.add("Różowy");
        colours.add("Brązowy");
        colours.add("Biały");
        colours.add("Czarny");
        colours.add("Szary");
        colours.add("Beżowy");
        colours.add("Turkusowy");
        colours.add("Srebrny");
        colours.add("Złoty");

        // Wyświetlanie zawartości zbioru

        System.out.println("--------------------------------------------------");
        System.out.println("Zawartość zbioru:");
        System.out.println("--------------------------------------------------");
        for (String colour : colours) {
            System.out.println(colour);
        }

        // Konwersja zbioru na tablicę

        String[] array = colours.toArray(new String[0]);

        // Wyświetlanie zawartości tablicy

        System.out.println("--------------------------------------------------");
        System.out.println("Zawartość tablicy:");
        System.out.println("--------------------------------------------------");
        for (String element : array) {
            System.out.println(element);
        }
    }
}