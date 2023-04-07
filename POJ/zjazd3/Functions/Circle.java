package Functions;

public class Circle {
    private final double radius;
    private final String color;

    public Circle() {
        this.radius = 1;
        this.color = "red";
    }
    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";
    }
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
}