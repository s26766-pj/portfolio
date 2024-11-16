package org.example.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Order {
    private static final Logger logger = LogManager.getLogger(Order.class);

    private static int nextOrderNumber = 1;

    private final int orderNumber;
    private final Pizza pizza;
    private final double totalPrice;

    public Order(Pizza pizza) {
        this.orderNumber = nextOrderNumber++;
        this.pizza = pizza;
        this.totalPrice = pizza.getPrice();
        logOrderInfo();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void logOrderInfo() {
        logger.info("Złożono zamówienie! Nr zamówienia: " + orderNumber + ", zamówiono: " + pizza + ", łączna wartość zamówienia: " + totalPrice);
    }
}