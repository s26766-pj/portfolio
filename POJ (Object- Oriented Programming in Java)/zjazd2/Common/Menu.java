package Common;

import Tasks.*;


public class Menu {
    public void run_menu(boolean state) {
        while (state) {
            Print.println(Print.menu_text());
            switch (User.get_line()) {
                case "koniec" -> state = false;
                case "1" -> Task_01.run_task_01();
                case "2" -> Task_02.run_task_02();
                case "3" -> Task_03.run_task_03();
                case "4" -> Task_04.run_task_04();
                case "5" -> Task_05.run_task_05();
                case "6" -> Task_06.run_task_06();
                case "7" -> Task_07.run_task_07();
                case "8" -> Task_08.run_task_08();
                case "9" -> Task_09.run_task_09();
                case "10" -> Task_10.run_task_10();
                case "11" -> Task_11.run_task_11();
            }
        }
    }
}

