package Tasks;

import Common.Print;
import Functions.Vehicle;


public class Task_11 {
    public static void run_task_11() {
        Print.println("Zadanie 11. Oblicz zasięg pojazdu na pełnym zbiorniku paliwa:");

        // dwa nowe obiekty (samochody)

        Vehicle miniVan = new Vehicle(7, 90, 15, "Minivan");
        Vehicle sportsCar = new Vehicle(2, 35, 7, "Auto sportowe");

        // pokaż informacje na temat samochodów

        miniVan.printInfo();
        sportsCar.printInfo();

        // pokaż ile litrów paliwa auta potrzebują do przejechania 2000 km

        miniVan.getFuelUseOn(2000);
        sportsCar.getFuelUseOn(2000);
    }
}