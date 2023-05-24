package zad1;
import java.util.ArrayList;


public class EvenNumbersGenerator {
    private final int size;

        public EvenNumbersGenerator(int size) {
            this.size = size;

        }
        public void show() {
            ArrayList<Integer> evenNumbers = new ArrayList<>();

            long startTime = System.nanoTime();

            for (int i = 1; evenNumbers.size() < size; i++) {
                if (i % 2 == 0) {
                    evenNumbers.add(i);
                }
            }

            long endTime = System.nanoTime();

            for (int i = 0; i < evenNumbers.size(); i++) {
                int number = evenNumbers.get(i);
                System.out.println("Liczba: " + number + ", numer indeksu: " + i);
            }

            double duration = (endTime - startTime) / 1_000_000.0;
            System.out.println("Czas wykonania operacji: " + duration + " ms");
        }
    }