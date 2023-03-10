import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            zadanie_13();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            print("BŁAD");
        }
    }
    public static void zadanie_13() {
        print("Najwiekszy element to: " + findMax(get_elements(get_quantity_of_elements())));
    }
    public static void print(String text) {
        System.out.println(text);
    }
    public static int get_quantity_of_elements() {
        print("Podaj ilosc elementow tablicy: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
    public static int[] get_elements(int quantity_of_elements) {
        print("Podaj elementy tablicy (ilosc elementow = " + quantity_of_elements + "): ");
        Scanner scan = new Scanner(System.in);
        String from_user = scan.nextLine();
        String[] elements_str_arr = from_user.split(" ");
        int[] arr = new int[0];
        for (int i = 0; i <= quantity_of_elements; i++) {
            arr = new int[i];
        }
        for (int j = 0; j < quantity_of_elements; j++) {
            arr[j] = Integer.parseInt(elements_str_arr[j]);
        }
        print("int[] = " + Arrays.toString(arr));
        return arr;
    }
    public static int findMax(int[] arr) {
        return findMaxRec(arr, arr.length - 1);
    }
    private static int findMaxRec(int[] arr, int n) {
        if (n == 0) {
            return arr[0];
        }
        int max = findMaxRec(arr, n - 1);
        return Math.max(max, arr[n]);
    }
}