import java.util.LinkedList;

public class Zadanie1 {
    public static void main(String[] args) {

        LinkedList<String> specialties = new LinkedList<>();

        // Wypełnianie listy wartościami

        specialties.add("Dermatolog");
        specialties.add("Endokrynolog");
        specialties.add("Gastroenterolog");
        specialties.add("Ginekolog");
        specialties.add("Immunolog");
        specialties.add("Internista");
        specialties.add("Kardiolog");
        specialties.add("Kardiochirurg");
        specialties.add("Neonatolog");
        specialties.add("Nefrolog");
        specialties.add("Neurolog");
        specialties.add("Okuspecialties");
        specialties.add("Onkolog");
        specialties.add("Ortopeda");
        specialties.add("Pediatra");
        specialties.add("Psychiatra");
        specialties.add("Pulmonolog");
        specialties.add("Radiolog");
        specialties.add("Radioterapeuta");
        specialties.add("Reumatolog");
        specialties.add("Stomatolog");
        specialties.add("Urolog");

        // Wyświetlanie oryginalnej listy

        System.out.println("Oryginalna lista: ");
        System.out.println("--------------------------------------------------");
        for (String specialty : specialties) {
            System.out.println(specialty);
        }

        // Usuwanie pierwszego i ostatniego elementu z listy

        String pierwszyElement = specialties.removeFirst();
        String ostatniElement = specialties.removeLast();

        // Wyświetlanie usuniętych elementów

        System.out.println("--------------------------------------------------");
        System.out.println("Usunięte elementy: " + pierwszyElement + ", " + ostatniElement);

        // Wyświetlanie listy po usunięciu elementów

        System.out.println("--------------------------------------------------");
        System.out.println("Lista po usunięciu elementów: ");
        System.out.println("--------------------------------------------------");
        for (String specialty : specialties) {
            System.out.println(specialty);
        }
    }
}
