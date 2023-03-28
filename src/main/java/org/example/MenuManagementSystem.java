package org.example;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MenuManagementSystem {
    private Map<String, Dish> dishes = new HashMap<>();

    public MenuManagementSystem() {
        dishes.put("Burger",new Dish("Burger",20.0));
    }

    public void addDish(Dish dish) {
        dishes.put(dish.getName(), dish);
    }

    public Dish getDishByName(String name) {
        return dishes.get(name);
    }

    public void updateDish(Dish dish) {
        dishes.put(dish.getName(), dish);
    }

    public void deleteDish(Dish dish) {
        dishes.remove(dish.getName());
    }
}
