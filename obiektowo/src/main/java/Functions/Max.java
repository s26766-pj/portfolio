package Functions;

public class Max {

    public static int findMax(int quantity_of_elements, String[] elements) {
    int[] arr = new int[quantity_of_elements];
        for (int i = 0; i <= quantity_of_elements; i++) {
        arr = new int[i];
    }
        for (int j = 0; j < quantity_of_elements; j++) {
        arr[j] = Integer.parseInt(elements[j]);
    }
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
