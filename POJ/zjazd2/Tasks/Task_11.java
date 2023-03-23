package Tasks;

import Common.Print;

import Functions.VehicleProg;


public class Task_11 {
    public static void run_task_11() {
        Print.println("Zadanie 11. Oblicz zasięg pojazdu na pełnym zbiorniku paliwa:");
        VehicleProg vp = new VehicleProg();
        vp.miniVan();
        vp.sportsCar();
    }
}