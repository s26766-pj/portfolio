package Functions;

import Common.Print;

public class Scalar {

    public int scalar_product = 0; // iloczyn skalarny

    public Scalar(int max_size, int nr_of_elementsA, int nr_of_elementsB, String[] vector1, String[] vector2) {

        int[] A = new int[max_size];
        int[] B = new int[max_size];

        int n, m;

        n = nr_of_elementsA;
        m = nr_of_elementsB;

        if (n <= 0 || n > max_size) {
            Print.error_msg("n musi być większe od zera");
            return;
        }


        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(vector1[i]);
        }

        if (m <= 0 || m > max_size) {
            Print.error_msg("n musi być większe od zera");
            return;
        }


        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(vector2[i]);
        }

        if (n != m) {
            Print.error_msg("Wektory muszą być równe");
            return;
        }

        for (int i = 0; i < n; i++) {
            scalar_product += A[i] * B[i];
        }
    }
    public int getProduct() {
        return scalar_product;
    }
}
