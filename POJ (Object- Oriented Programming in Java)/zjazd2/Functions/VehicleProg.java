package Functions;

import Common.Print;

public class VehicleProg {

    public VehicleProg() {

    }
    public void miniVan() {
        Vehicle miniVan = new Vehicle(7, 90, 15);
        double[] data = miniVan.getData();
        double tankCapacity = data[1];
        double fuelConsumption = data[2];
        double range = tankCapacity / (fuelConsumption / 100);
        Print.println("Zasięg MiniVan-a przy pełnym zbioniku wysnosi: " + Round.getRound(range, 1) + " km");
    }
    public void sportsCar() {
        Vehicle sportsCar = new Vehicle(2, 35, 7);
        double[] data = sportsCar.getData();
        double tankCapacity = data[1];
        double fuelConsumption = data[2];
        double range = tankCapacity / (fuelConsumption / 100);
        Print.println("Zasięg samochodu sportowego przy pełnym zbioniku wysnosi: " + Round.getRound(range, 1) + " km");
    }

}
