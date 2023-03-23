package Functions;

import Common.Print;

public class TruthTable {
    private final boolean[] logic_p;
    private final boolean[] logic_q;
    private final int columns;

    public TruthTable(boolean[] logic_p, boolean[] logic_q, int columns) {
        this.logic_p = logic_p;
        this.logic_q = logic_q;
        this.columns = columns;
    }

    // wiersz AND

    public boolean[] logic_and() {
        boolean[] logic_and = new boolean[logic_p.length];
        for (int i = 0; i < logic_p.length; i++) {
            logic_and[i] = (logic_p[i] & logic_q[i]);
        }
        return logic_and;
    }

    // wiersz OR

    public boolean[] logic_or() {
        boolean[] logic_or = new boolean[logic_p.length];
        for (int i = 0; i < logic_p.length; i++) {
            logic_or[i] = (logic_p[i] | logic_q[i]);
        }
        return logic_or;
    }

    // wiersz XOR

    public boolean[] logic_xor() {
        boolean[] logic_xor = new boolean[logic_p.length];
        for (int i = 0; i < logic_p.length; i++) {
            logic_xor[i] = (logic_p[i] ^ logic_q[i]);
        }
        return logic_xor;
    }

    // wiersz NOT

    public boolean[] logic_not() {
        boolean[] logic_not = new boolean[logic_p.length];
        for (int i = 0; i < logic_p.length; i++) {
            logic_not[i] = !logic_p[i];
        }
        return logic_not;
    }

    // buduje tabele w postaci macierzy

    public boolean[][] buildTable() {
        boolean[][] table = new boolean[columns][logic_q.length];
        boolean[] values_line = new boolean[columns];
        for (int w = 0; w < columns; w++) {

                switch (w) {
                    case 0 -> values_line = logic_p;
                    case 1 -> values_line = logic_q;
                    case 2 -> values_line = logic_and();
                    case 3 -> values_line = logic_or();
                    case 4 -> values_line = logic_xor();
                    case 5 -> values_line = logic_not();
                }
            System.arraycopy(values_line, 0, table[w], 0, logic_q.length);

        }
        return table;
    }

    // dodaje nagłówek tabeli oraz drukuje tabele przy pomocy transpozycji

    public void showT() {
        int i;
        int j;
        String[] head_of_table = { "P", "Q", "AND", "OR", "XOR", "NOT(P)"};
        for (int h = 0; h < columns; h++) {
            Print.print_in_line(head_of_table[h] + "\t\t");
        }
        Print.emptyln();
        for (i = 0; i < logic_q.length; i++) {
            for (j = 0; j < columns; j++) {
                Print.print_in_line(buildTable()[j][i] + "\t");
            }
            Print.emptyln();
        }
    }
}