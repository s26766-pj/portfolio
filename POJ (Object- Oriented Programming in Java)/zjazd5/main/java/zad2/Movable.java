package zad2;

public interface Movable {

    // moj diagram UML troche rozni sie od Pani diagramu ;/

    MovablePoint mp = new MovablePoint(0, 0);
    static void moveUp() {
        mp.moveUp();
        String pointString = mp.toString();
        System.out.println(pointString);
    }
    static void moveDown() {
        mp.moveDown();
        String pointString = mp.toString();
        System.out.println(pointString);
    }
    static void moveLeft() {
        mp.moveLeft();
        String pointString = mp.toString();
        System.out.println(pointString);
    }
    static void moveRight() {
        mp.moveRight();
        String pointString = mp.toString();
        System.out.println(pointString);
    }
}
