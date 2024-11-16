import Common.Print;
import Functions.TestAuthor;
import Functions.TestCircle;

public class Main {
    public static void main(String[] args) {

        Print.println("Zadanie 3.1");
        TestCircle tc = new TestCircle();
        tc.main();

        Print.println("Zadanie 3.2");
        TestAuthor ta = new TestAuthor();
        ta.main();

    }
}