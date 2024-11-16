package Functions;

import Common.Print;

import java.text.DecimalFormat;

public class Vehicle {
    private final double passengers;
    private final double fuelcap;
    private final double lkm;
    private final String label;

    public Vehicle(double passengers, double fuelcap, double lkm, String label) {
        this.passengers = passengers;
        this.fuelcap = fuelcap;
        this.lkm = lkm;
        this.label = label;
    }
    public double getPassengers() {
        return passengers;
    }
    public double getFuelcap() {
        return fuelcap;
    }
    public double getLkm() {
        return lkm;
    }
    public String getLabel() {
        return label;
    }
    public double range() {
        return getFuelcap() / (getLkm() / 100);

    }
    public void printInfo() {
        DecimalFormat specific_format = new DecimalFormat("#");
        Print.print_in_line(getLabel());
        Print.print_in_line(" przewozi ");
        Print.print_in_line(specific_format.format(getPassengers()));
        Print.print_in_line(" osób na odległość do ");
        Print.print_in_line(specific_format.format(range()));
        Print.print_in_line(" kilometrów");
        Print.emptyln();
    }
    public void getFuelUseOn(double distance) {
        double fuel_usage = getLkm() / 100 * distance;
        Print.print_in_line(getLabel());
        Print.print_in_line(" potrzebuje ok. ");
        Print.print_in_line(String.valueOf(fuel_usage));
        Print.print_in_line(" litrów paliwa aby pokonać dystans ");
        Print.print_in_line(String.valueOf(distance));
        Print.print_in_line(" kilometrów.");
        Print.emptyln();

    }
}