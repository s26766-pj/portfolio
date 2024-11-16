import zad1.EvenNumbersGenerator;
import zad2.Movable;
import zad3.Coffee;

public class Main {
    public static void main(String[] args) {

        System.out.println("----- POJ ----- Laboratorium 5 ------ Zadanie 1 -----");

        EvenNumbersGenerator gen = new EvenNumbersGenerator(50);
        gen.show();

        System.out.println("----- POJ ----- Laboratorium 5 ------ Zadanie 2 -----");

        Movable.moveUp();
        Movable.moveUp();
        Movable.moveUp();
        Movable.moveDown();
        Movable.moveDown();
        Movable.moveDown();
        Movable.moveLeft();
        Movable.moveLeft();
        Movable.moveLeft();
        Movable.moveRight();
        Movable.moveRight();
        Movable.moveRight();

        System.out.println("----- POJ ----- Laboratorium 5 ------ Zadanie 3 -----");

        Coffee c = new Coffee();






    }
}