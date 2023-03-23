package Tasks;

import Common.Print;
import Functions.PrimitiveTypes;

public class Task_03 {

    public static void run_task_03() {
        Print.println("Zadanie 3. Wyświetl wszystkie typy proste:");
        PrimitiveTypes pt = new PrimitiveTypes();
        Print.println("short s = " + pt.getS());
        Print.println("int i = " + pt.getI());
        Print.println("long l = " + pt.getL());
        Print.println("float f = " + pt.getF());
        Print.println("double d = " + pt.getD());
        Print.println("char c = " + pt.getC());
        Print.println("String s = " + pt.getStr());
        Print.println("boolean b = " + pt.getB());
    }
}
