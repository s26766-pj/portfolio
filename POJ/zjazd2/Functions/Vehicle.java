package Functions;

public class Vehicle {
    private final double passengers;
    private final double fuelcap;
    private final double lkm;

    public Vehicle(double passengers, double fuelcap, double lkm) {
        this.passengers = passengers;
        this.fuelcap = fuelcap;
        this.lkm = lkm;
    }
    public double[] getData() {
        double[] getData = new double[3];
        getData[0] = passengers;
        getData[1] = fuelcap;
        getData[2] = lkm;
        return getData;
    }
}