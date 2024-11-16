package zad2;

class MovablePoint implements Movable {

    private int x;
    private int y;

    public MovablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ":" + y + ")";
    }
    public void moveUp() {
        y = y + 1;
    }
    public void moveDown() {
        y = y - 1;
    }
    public void moveLeft() {
        x = x - 1;
    }
    public void moveRight() {
        x = x + 1;
    }

}