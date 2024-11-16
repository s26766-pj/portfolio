#include <stdio.h>

int main() {
    int n, i, num;
    int sum = 0;

    printf("Podaj ilość liczb, które chcesz zsumować: ");
    scanf("%d", &n);

    printf("Podaj %d liczb:\n", n);
    for (i = 0; i < n; i++) {
        scanf("%d", &num);
        sum += num;
    }

    printf("Suma podanych liczb wynosi: %d\n", sum);

    return 0;
}