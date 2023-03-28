package org.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderManagementSystem orderManager;
    private MenuManagementSystem menuManagementSystem;

    public OrderController(OrderManagementSystem orderManager,MenuManagementSystem menuManagementSystem) {
        this.orderManager = orderManager;
        this.menuManagementSystem = menuManagementSystem;
    }

    @PostMapping
    public Order addOrder(@RequestBody OrderRequest orderRequest) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest orderItemRequest : orderRequest.getItems()) {
            Dish menuItem = menuManagementSystem.getDishByName(orderItemRequest.getName());
            OrderItem orderItem = new OrderItem(menuItem, orderItemRequest.getQuantity());
            orderItems.add(orderItem);
        }
        Order order = new Order();
        order.setOrderItems(orderItems);
        return orderManager.addOrder(order);
    }
}
