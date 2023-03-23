package Tasks;

import Common.Print;
import Functions.Person;


public class Task_01 {


    public static void run_task_01() {
        Print.println("Zadanie 1. Wyświetl imie, nazwisko, grupe i kierunek studiów:");
        // zbuduj obiekt
        Person p = new Person();
        // wczytaj dane
        p.firstname = "Kamil";
        p.surname = "Koniak";
        p.group = 25;
        p.field = "Informatyka";
        // pokaz dane
        Print.println("imie: " + p.getFirstname());
        Print.println("nazwisko: " + p.getSurname());
        Print.println("grupa: " + p.getGroup());
        Print.println("kierunek: " + p.getField());
    }



}