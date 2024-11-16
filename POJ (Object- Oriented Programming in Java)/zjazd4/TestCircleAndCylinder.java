import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCircleAndCylinder {

    @Test
    public void testCylinder() {
        Circle circle = new Circle(2.0);
        Cylinder cylinder = new Cylinder(2.0, 4.0);

        // Testowanie klasy Circle

        assertEquals(2.0, circle.getRadius(), 0.01);
        assertEquals(12.57, circle.getArea(), 0.01);

        // Testowanie klasy Cylinder

        assertEquals(4.0, cylinder.getHeight(), 0.01);
        assertEquals(50.27, cylinder.getVolume(), 0.01);
    }
}