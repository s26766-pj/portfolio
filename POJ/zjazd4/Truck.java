class Truck extends Car implements Purchase {
    int weight;

    double getSalePrice() {
        if (weight > 2000) {
            return super.getSalePrice() * 0.9;
        } else {
            return super.getSalePrice();
        }
    }

    public String getPurchaseInfo() {
        return "TRUCK: ";
    }
}
