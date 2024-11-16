package junit;

import org.junit.Assert;
import org.junit.Test;
import zad4.*;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestKsiazek {

    @Test
    public void testSortowanieKsiazekPoTytule() {
        List<Ksiazka> listaKsiazek = new ArrayList<>();

        listaKsiazek.add(new Ebook("Harry Potter", "J.K. Rowling", 400, 2048, "PDF"));
        listaKsiazek.add(new KsiazkaPapierowa("Władca Pierścieni", "J.R.R. Tolkien", 1200, 1954));
        listaKsiazek.add(new Ebook("1984", "George Orwell", 328, 1024, "EPUB"));
        listaKsiazek.add(new KsiazkaPapierowa("Mistrz i Małgorzata", "Michaił Bułhakow", 480, 1967));
        System.out.println("lista książek:");

        // Sortowanie listy książek po tytule
        listaKsiazek.sort(Comparator.comparing(Ksiazka::getTytul));

        // Drukowanie listy
        for (Ksiazka ksiazka : listaKsiazek) {
            System.out.println(ksiazka);
        }

        // Przygotowanie oczekiwanej posortowanej listy
        List<String> oczekiwanaLista = new ArrayList<>();
        oczekiwanaLista.add("1984");
        oczekiwanaLista.add("Harry Potter");
        oczekiwanaLista.add("Mistrz i Małgorzata");
        oczekiwanaLista.add("Władca Pierścieni");

        // Sprawdzenie czy lista została posortowana poprawnie
        for (int i = 0; i < listaKsiazek.size(); i++) {
            Assert.assertEquals(oczekiwanaLista.get(i), listaKsiazek.get(i).getTytul());
        }
    }
}

