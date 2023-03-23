package Tasks;

import Common.Print;

import Functions.TruthTable;


public class Task_08 {
    public static void run_task_08() {
        Print.println("Zadanie 8. Tabela prawdy:");

        // inicjacja p i q

        boolean[] logic_p = {true, true, false, false};
        boolean[] logic_q = {true, false, true, false};

        // podaje p i q oraz liczbe kolumn tabeli

        TruthTable tt = new TruthTable(logic_p, logic_q, 6);

        // drukuje tabele przy pomocy transpozycji macierzy

        tt.showT();
    }
}