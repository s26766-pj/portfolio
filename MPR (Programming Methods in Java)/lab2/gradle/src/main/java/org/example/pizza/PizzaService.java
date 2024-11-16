package org.example.pizza;

import lombok.Getter;
import org.example.model.Pizza;
import org.example.model.Order;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PizzaService {
    @Getter
    private final List<Pizza> availablePizzas;
    private final Logger logger = LogManager.getLogger(PizzaService.class);

    public PizzaService() {
        availablePizzas = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) {
        availablePizzas.add(pizza);
    }

    public Order makeOrder(Pizza pizza) {
        Pizza foundPizza = availablePizzas.stream()
                .filter(p -> p.getName().equals(pizza.getName()))
                .findFirst()
                .orElseThrow(() -> new PizzaNotFoundException("Pizza not found: " + pizza.getName()));

        return new Order(foundPizza);
    }
    public List<Pizza> getAvailablePizzas() {
        return availablePizzas;
    }

}