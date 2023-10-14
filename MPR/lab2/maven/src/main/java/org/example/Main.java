package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.model.Order;
import org.example.model.Pizza;
import org.example.pizza.PizzaNotFoundException;
import org.example.pizza.PizzaService;
import java.util.List;

public class Main {

    private static final Logger logger = (Logger) LogManager.getLogger(Main.class);


    public static void main(String[] args) {

        PizzaService pizzaService = new PizzaService();

        pizzaService.addPizza(new Pizza("Margarita", 20.0));
        pizzaService.addPizza(new Pizza("Pepperoni", 25.0));
        pizzaService.addPizza(new Pizza("Meat", 22.0));
        pizzaService.addPizza(new Pizza("Fungi", 22.0));

        List<Pizza> availablePizzas = pizzaService.getAvailablePizzas();
        System.out.println("Dostępne pizze:");
        for (Pizza pizza : availablePizzas) {
            System.out.println(pizza.getName() + " - " + pizza.getPrice() + " PLN");
        }
        System.out.println(" ");
        try {
            Order order1 = pizzaService.makeOrder(new Pizza("Margarita", 20.0));
            Order order2 = pizzaService.makeOrder(new Pizza("Pepperoni", 25.0));

            Order order3 = pizzaService.makeOrder(new Pizza("Meat", 40.0));
            Order order4 = pizzaService.makeOrder(new Pizza("Meat", 40.0));
            Order order5 = pizzaService.makeOrder(new Pizza("Fungi", 40.0));

            Order order6 = pizzaService.makeOrder(new Pizza("Hawaiian", 22.0));

        } catch (PizzaNotFoundException e) {
            logger.error("Wystąpił błąd przy zamawianiu pizzy! Pizza nie istnieje!", e);
        }
    }
}