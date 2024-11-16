public class AutoShop {
    public static void main(String[] args) {
        Sedan sedan = new Sedan();
        sedan.speed = 200;
        sedan.regularPrice = 50000.0;
        sedan.color = "Red";
        sedan.length = 22;
        System.out.println(sedan.getPurchaseInfo() + sedan.getSalePrice());

        Ford ford1 = new Ford();
        ford1.speed = 180;
        ford1.regularPrice = 40000.0;
        ford1.color = "Blue";
        ford1.year = 2022;
        ford1.manufacturerDiscount = 5000;
        System.out.println(ford1.getPurchaseInfo() + ford1.getSalePrice());

        Ford ford2 = new Ford();
        ford2.speed = 200;
        ford2.regularPrice = 60000.0;
        ford2.color = "Black";
        ford2.year = 2021;
        ford2.manufacturerDiscount = 7000;
        System.out.println(ford2.getPurchaseInfo() + ford2.getSalePrice());

        Truck truck = new Truck();
        truck.speed = 120;
        truck.regularPrice = 80000.0;
        truck.color = "White";
        truck.weight = 3000;
        System.out.println(truck.getPurchaseInfo() + truck.getSalePrice());
    }
}