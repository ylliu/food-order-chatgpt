import org.example.Dish;
import org.example.OrderItem;
import org.example.OrderManagementSystem;
import org.junit.Test;
import org.example.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderManagementSystemTest {
    @Test
    public void testAddOrder() {
        OrderManagementSystem oms = new OrderManagementSystem();

        Dish dish1 = new Dish("糖醋排骨", 20.0);
        Dish dish2 = new Dish("宫保鸡丁", 18.0);

        oms.getMenuManagementSystem().addDish(dish1);
        oms.getMenuManagementSystem().addDish(dish2);

        OrderItem orderItem1 = new OrderItem(dish1, 2);
        OrderItem orderItem2 = new OrderItem(dish2, 3);

        oms.addOrderItem(orderItem1);
        oms.addOrderItem(orderItem2);

        Order retrievedOrder = oms.getOrders().get(0);
        assertEquals(2, retrievedOrder.getOrderItems().get(0).getQuantity());
        assertEquals(3, retrievedOrder.getOrderItems().get(1).getQuantity());
    }

    @Test
    public void testCancelOrder() {
        OrderManagementSystem oms = new OrderManagementSystem();

        Dish dish1 = new Dish("糖醋排骨", 20.0);
        Dish dish2 = new Dish("宫保鸡丁", 18.0);

        oms.getMenuManagementSystem().addDish(dish1);
        oms.getMenuManagementSystem().addDish(dish2);

        OrderItem orderItem1 = new OrderItem(dish1, 2);
        OrderItem orderItem2 = new OrderItem(dish2, 3);

        oms.addOrderItem(orderItem1);
        oms.addOrderItem(orderItem2);

        oms.cancelOrder(oms.getOrders().get(0));

        assertEquals(0, oms.getOrders().size());
    }

    @Test
    public void testModifyOrder() {
        OrderManagementSystem oms = new OrderManagementSystem();

        Dish dish1 = new Dish("糖醋排骨", 20.0);
        Dish dish2 = new Dish("宫保鸡丁", 18.0);

        oms.getMenuManagementSystem().addDish(dish1);
        oms.getMenuManagementSystem().addDish(dish2);

        OrderItem orderItem1 = new OrderItem(dish1, 2);
        OrderItem orderItem2 = new OrderItem(dish2, 3);

        oms.addOrderItem(orderItem1);
        oms.addOrderItem(orderItem2);

        OrderItem newOrderItem1 = new OrderItem(dish1, 3);
        OrderItem newOrderItem2 = new OrderItem(dish2, 4);

        oms.modifyOrder(oms.getOrders().get(0), newOrderItem1, newOrderItem2);

        Order retrievedOrder = oms.getOrders().get(0);
        assertEquals(3, retrievedOrder.getOrderItems().get(0).getQuantity());
        assertEquals(4, retrievedOrder.getOrderItems().get(1).getQuantity());
    }
}