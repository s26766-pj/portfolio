import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {

            Person person1 = new Person("Jan", 32);
            Person person2 = new Person("Anna", 27);
            Person person3 = new Person("Marek", 22);


            List<Person> personList = new ArrayList<>();
            personList.add(person1);
            personList.add(person2);
            personList.add(person3);

            Set<Person> personSet = new HashSet<>();
            personSet.add(person1);
            personSet.add(person2);
            personSet.add(person3);

            Map<String, Person> personMap = new HashMap<>();
            personMap.put(person1.getName(), person1);
            personMap.put(person2.getName(), person2);
            personMap.put(person3.getName(), person3);

            System.out.println("Lista osób:");
            for (Person person : personList) {
                System.out.println("Imię: " + person.getName() + ", Wiek: " + person.getAge());
            }

            System.out.println("\nZbiór osób:");
            for (Person person : personSet) {
                System.out.println("Imię: " + person.getName() + ", Wiek: " + person.getAge());
            }

            System.out.println("\nMapa osób:");
            for (String name : personMap.keySet()) {
                Person person = personMap.get(name);
                System.out.println("Imię: " + name + ", Wiek: " + person.getAge());
            }

            // 4.1. Operacja reduce - Oblicz średni wiek osób w liście
            OptionalDouble averageAge = personList.stream()
                    .mapToInt(Person::getAge)
                    .average();
            if (averageAge.isPresent()) {
                System.out.println("\n4.1) Średni wiek osób: " + averageAge.getAsDouble());
            } else {
                System.out.println("Brak danych do obliczenia średniego wieku.");
            }

            // 4.2. Operacja map - Stwórz nową listę, która zawiera tylko imiona osób
            List<String> names = personList.stream()
                    .map(Person::getName)
                    .toList();
            System.out.println("4.2) Lista imion: " + names);

            // 4.3. Operacja filter - Stwórz listę osób w wieku powyżej 25 lat
            List<Person> peopleAbove25 = personList.stream()
                    .filter(person -> person.getAge() > 25)
                    .toList();
            System.out.println("4.3) Lista osób powyżej 25 lat: " + peopleAbove25);

            // 4.4. Operacja sort - Posortuj listę osób alfabetycznie według ich imion
            List<Person> sortedPeople = personSet.stream()
                    .sorted(Comparator.comparing(Person::getName))
                    .toList();
            System.out.println("4.4) Posortowana lista osób: " + sortedPeople);

            // 4.5. Operacja forEach - Wypisz imiona i wiek wszystkich osób z listy w konsoli
            System.out.println("4.5) Imiona i wiek osób (forEach):");
            personList.forEach(person -> System.out.println(person.getName() + ", Wiek: " + person.getAge()));

            // 4.6. Operacja min - Znajdź osobę o najniższym/największym wieku
            Optional<Person> youngestPerson = personList.stream()
                    .min(Comparator.comparingInt(Person::getAge));
            youngestPerson.ifPresent(person -> System.out.println("\n4.6) MIN - Najmłodsza osoba: " + person.getName()));

            // 4.6. Operacja max - Znajdź osobę o najniższym/największym wieku
            Optional<Person> oldestPerson = personList.stream()
                    .max(Comparator.comparingInt(Person::getAge));
            oldestPerson.ifPresent(person -> System.out.println("4.6) MAX - Najstarsza osoba: " + person.getName()));


        } catch (InvalidAgeException e) {
            System.err.println("Złapano wyjątek: " + e.getMessage());
        }

    }
}