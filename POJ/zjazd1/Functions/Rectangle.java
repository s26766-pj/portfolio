package Functions;

public class Rectangle {
    private final float sideA;
    private final float sideB;

    public Rectangle(float sideA, float sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }
    public float getSurfaceArea() {
        return sideA * sideB;
    }
    public float getCircuit() {
        return 2 * (sideA + sideB);
    }
}





