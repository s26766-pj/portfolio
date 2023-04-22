class Ford extends Car implements Purchase {
    int year;
    int manufacturerDiscount;

    double getSalePrice() {
        return super.getSalePrice() - manufacturerDiscount;
    }

    public String getPurchaseInfo() {
        return "FORD: ";
    }
}