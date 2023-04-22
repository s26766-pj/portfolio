public class Main {
    public static void main(String[] args) {
        Sedan sedan = new Sedan();
        sedan.speed = 160;
        sedan.regularPrice = 20000;
        sedan.color = "red";
        sedan.length = 10;
        System.out.println("SEDAN: " + sedan.getSalePrice() + " " + sedan.getPurchaseInfo());

        Ford ford1 = new Ford();
        ford1.color = "black";
        ford1.speed = 156;
        ford1.regularPrice = 4452;
        ford1.year = 2005;
        ford1.manufacturerDiscount = 10;
        System.out.println("FORD1: " + ford1.getSalePrice() + " " + ford1.getPurchaseInfo());

        Ford ford2 = new Ford();
        ford2.color = "pink";
        ford2.speed = 155;
        ford2.regularPrice = 5000;
        ford2.year = 1998;
        ford2.manufacturerDiscount = 5;
        System.out.println("FORD2: " + ford2.getSalePrice() + " " + ford2.getPurchaseInfo());

        Truck truck = new Truck();
        truck.color = "gold";
        truck.speed = 200;
        truck.regularPrice = 500000;
        truck.weight = 5000;
        System.out.println("TRUCK: " + truck.getSalePrice() + " " + truck.getPurchaseInfo());
    }
}
