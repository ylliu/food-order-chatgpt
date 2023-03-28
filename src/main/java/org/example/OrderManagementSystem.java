package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderManagementSystem {
    private List<Order> orders;
    private MenuManagementSystem menuManagementSystem;

    public OrderManagementSystem() {
        orders = new ArrayList<>();
        menuManagementSystem = new MenuManagementSystem();
    }



    public void addOrderItem(OrderItem orderItem) {
        Order order;
        if (orders.isEmpty()) {
            order = new Order();
            orders.add(order);
        } else {
            order = orders.get(orders.size() - 1);
        }
        order.addOrderItem(orderItem);
    }

    public void modifyOrder(Order order, OrderItem newOrderItem1, OrderItem newOrderItem2) {
        order.modifyOrderItem(0, newOrderItem1);
        order.modifyOrderItem(1, newOrderItem2);
    }

    public void cancelOrder(Order order) {
        order.cancelOrder();
        orders.remove(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public MenuManagementSystem getMenuManagementSystem() {
        return menuManagementSystem;
    }

    public Order addOrder(Order order) {
        orders.add(order);
        return order;
    }

}




