package Tasks;

import Common.Print;
import Common.User;
import Functions.Rectangle;
import java.util.InputMismatchException;

public class Task_01 {
    public static void run_task_01() {
      Print.println("Zadanie 1. Podaj dwa boki prostokąta: ");
      try {
          Rectangle r = new Rectangle(User.get_float(), User.get_float());
          Print.println("Pole prostokąta = " + r.getSurfaceArea());
          Print.println(("Obwód prostokąta = " + r.getCircuit()));
      } catch (InputMismatchException e) {
          Print.error_msg("IME000");
      }
    }
}


