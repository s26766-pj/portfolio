class Sedan extends Car {
    int length;

    double getSalePrice() {
        if (length > 20) {
            return super.getSalePrice() * 0.95;
        } else {
            return super.getSalePrice() * 0.9;
        }
    }

    public String getPurchaseInfo() {
        return "SEDAN: ";
    }
}