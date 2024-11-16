package zad3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Coffee {
    public Coffee() {

        // a) utworzysz listę stringów
        List<String> coffeeList = new ArrayList<>();

        // b) do listy dodasz 6 nazw kaw: espresso, latte, cappuccino, mocha, auLait, macchiato
        coffeeList.add("espresso");
        coffeeList.add("latte");
        coffeeList.add("cappuccino");
        coffeeList.add("mocha");
        coffeeList.add("auLait");
        coffeeList.add("macchiato");

        // b) i wypiszesz je na konsolę
        System.out.println("Lista kaw:");
        System.out.println(coffeeList);


        System.out.println();

        // c) użyjesz Iterator<String> do przejścia przez wszystkie elementy listy i wypiszesz je na konsolę
        System.out.println("Użycie Iteratora:");
        Iterator<String> iterator = coffeeList.iterator();
        while (iterator.hasNext()) {
            String coffee = iterator.next();
            System.out.println(coffee);
        }

        System.out.println();

        // d) użyjesz pętli foreach, aby przejść przez wszystkie elementy listy i wypiszesz je dużymi literami na konsolę
        System.out.println("Pętla foreach:");
        for (String coffee : coffeeList) {
            System.out.println(coffee.toUpperCase());
        }

        System.out.println();

        // e) korzystając z pętli for, wypisz na konsolę po 4 pierwsze litery z każdego wyrazu, przechowywanego zaimplementowanej liście
        System.out.println("Pierwsze 4 litery:");
        for (String coffee : coffeeList) {
            if (coffee.length() >= 4) {
                String firstFourLetters = coffee.substring(0, 4);
                System.out.println(firstFourLetters);
            }
        }
    }
}
