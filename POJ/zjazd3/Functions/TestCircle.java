package Functions;

import Common.Print;

public class TestCircle {


    public void main() {
        Circle c1 = new Circle();
        Circle c2 = new Circle(2);
        Circle c3 = new Circle(4, "blue");
        Circle c4 = new Circle(7, "green");

        Print.print_in_line("The circle c1 has radius of " + c1.getRadius());
        Print.print_in_line(" and area of " + c1.getArea());
        Print.print_in_line(" and color of " + c1.getColor());
        Print.emptyln();
        Print.print_in_line("The circle c2 has radius of " + c2.getRadius());
        Print.print_in_line(" and area of " + c2.getArea());
        Print.print_in_line(" and color of " + c2.getColor());
        Print.emptyln();
        Print.print_in_line("The circle c3 has radius of " + c3.getRadius());
        Print.print_in_line(" and area of " + c3.getArea());
        Print.print_in_line(" and color of " + c3.getColor());
        Print.emptyln();
        Print.print_in_line("The circle c4 has radius of " + c4.getRadius());
        Print.print_in_line(" and area of " + c4.getArea());
        Print.print_in_line(" and color of " + c4.getColor());
        Print.emptyln();



    }

}