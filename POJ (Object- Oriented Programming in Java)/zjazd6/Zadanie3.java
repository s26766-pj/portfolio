import java.util.Iterator;
import java.util.TreeSet;

public class Zadanie3 {

    public static void compareElements(TreeSet<String> tree1, TreeSet<String> tree2) {
        for (String element1 : tree1) {
            boolean isFound = tree2.contains(element1);
            System.out.println("Czy element <<" + element1 + ">> w drzewie tree1 jest taki sam jak w tree2?");
            System.out.println((isFound ? "Tak" : "Nie"));
        }
    }

    public static void main(String[] args) {


        // a. Tworzenie i wypełnianie tree1
        TreeSet<String> tree1 = new TreeSet<>();
        tree1.add("Black");
        tree1.add("Green");
        tree1.add("Orange");
        tree1.add("Red");
        tree1.add("White");

        System.out.println("\na) Drzewo zawierające pięć nazw kolorów \ntree1: " + tree1);

        // b. Iteracja po elementach tree1
        System.out.println("\nb) Iteracja wszystkich elementach drzewa:");
        Iterator<String> iterator = tree1.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        // c. Tworzenie tree2 i dodawanie do tree1
        TreeSet<String> tree2 = new TreeSet<>();
        tree2.add("Black");
        tree2.add("Pink");
        tree2.add("White");

        System.out.println("\nc) Dodanie do istiejącego drzewa nowego drzewa binarngo:");
        System.out.println("tree1: " + tree1);
        System.out.println("tree2: " + tree2);

        tree1.addAll(tree2);

        System.out.println("tree1 po zsumowaniu z tree2: " + tree1);

        // d. Wyświetlanie elementów tree1 w odwrotnej kolejności
        System.out.println("\nd) Wypisanie elementów drzewa w odwrotnej kolejności:");
        System.out.println("Oryginalne drzewo tree1: " + tree1);
        Iterator<String> descendingIterator = tree1.descendingIterator();
        System.out.println("Odwrotna kolejność:");
        while (descendingIterator.hasNext()) {
            String element = descendingIterator.next();
            System.out.println(element);
        }

        // e. Wyświetlanie pierwszego i ostatniego elementu tree1
        System.out.println("\ne) Wypisanie pierwszego i ostatniego elementu przechowywanego na drzewie:");
        System.out.println("tree1: " + tree1);
        System.out.println("Pierwszy element drzewa: " + tree1.first());
        System.out.println("Ostatni element drzewa: " + tree1.last());

        // f. Klonowanie tree1 do tree3
        TreeSet<String> tree3 = (TreeSet<String>) tree1.clone();

        System.out.println("\nf) Sklonowane drzewa binarnego do innego drzewa i wypisanie nowego drzewa na ekran:");
        System.out.println("tree1: " + tree1);
        System.out.println("Nowe drzewo tree3: " + tree3);

        // g. Wyświetlanie liczby elementów w drzewie
        System.out.println("\ng) Liczba elementów w drzewie:");
        System.out.println("tree1: " + tree1);
        System.out.println("Rozmiar tree1: " + tree1.size());

        // h. Porównywanie elementów tree1 i tree2
        System.out.println("\nh) Porównywanie elementów przechowywanych w dwóch drzewach binarnych:");
        compareElements(tree1, tree2);

    }
}
