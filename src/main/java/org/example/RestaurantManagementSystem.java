package org.example;

import java.util.HashMap;
import java.util.Map;

public class RestaurantManagementSystem {
    private Map<String, Restaurant> restaurants = new HashMap<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
    }

    public Restaurant getRestaurantById(String id) {
        return restaurants.get(id);
    }

    public void updateRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
    }
}

