#include <stdio.h>

int main() {
    char operator;
    double num1, num2, wynik;

    while(1) {
        printf("\nPodaj operator (+, -, *, /) lub Q aby zakończyć: ");
        scanf(" %c", &operator);

        if(operator == 'Q' || operator == 'q') {
            break;
        }

        printf("Podaj dwie liczby oddzielone spacją: ");
        scanf("%lf %lf", &num1, &num2);

        switch(operator) {
            case '+':
                wynik = num1 + num2;
                printf("%.2lf + %.2lf = %.2lf\n", num1, num2, wynik);
                break;

            case '-':
                wynik = num1 - num2;
                printf("%.2lf - %.2lf = %.2lf\n", num1, num2, wynik);
                break;

            case '*':
                wynik = num1 * num2;
                printf("%.2lf * %.2lf = %.2lf\n", num1, num2, wynik);
                break;

            case '/':
                if(num2 == 0) {
                    printf("Nie można dzielić przez zero.\n");
                }
                else {
                    wynik = num1 / num2;
                    printf("%.2lf / %.2lf = %.2lf\n", num1, num2, wynik);
                }
                break;

            default:
                printf("Błędny operator. Podaj operator spośród +, -, *, / lub Q aby zakończyć.\n");
                break;
        }
    }

    return 0;
}
