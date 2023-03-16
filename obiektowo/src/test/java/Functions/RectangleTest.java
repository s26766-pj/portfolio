package Functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTest {

    @Test
    public void testRectangle() {
        Rectangle rectangle = new Rectangle(5, 10);
        Assertions.assertEquals(50, rectangle.getSurfaceArea(), 0.0);
        Assertions.assertEquals(30, rectangle.getCircuit(), 0.0);
    }
}
