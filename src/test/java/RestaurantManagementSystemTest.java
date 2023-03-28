import org.example.Restaurant;
import org.example.RestaurantManagementSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantManagementSystemTest {
    @Test
    public void testAddRestaurant() {
        RestaurantManagementSystem rms = new RestaurantManagementSystem();

        Restaurant restaurant = new Restaurant("ABC餐厅", "ABC地址");
        rms.addRestaurant(restaurant);

        Restaurant retrievedRestaurant = rms.getRestaurantById(restaurant.getId());
        assertEquals(restaurant, retrievedRestaurant);
    }

    @Test
    public void testGetRestaurantById() {
        RestaurantManagementSystem rms = new RestaurantManagementSystem();

        Restaurant restaurant = new Restaurant("ABC餐厅", "ABC地址");
        rms.addRestaurant(restaurant);

        Restaurant retrievedRestaurant = rms.getRestaurantById(restaurant.getId());
        assertEquals(restaurant, retrievedRestaurant);
    }

    @Test
    public void testUpdateRestaurant() {
        RestaurantManagementSystem rms = new RestaurantManagementSystem();

        Restaurant restaurant = new Restaurant("ABC餐厅", "ABC地址");
        rms.addRestaurant(restaurant);

        restaurant.setName("DEF餐厅");
        restaurant.setAddress("DEF地址");
        rms.updateRestaurant(restaurant);

        Restaurant retrievedRestaurant = rms.getRestaurantById(restaurant.getId());
        assertEquals("DEF餐厅", retrievedRestaurant.getName());
        assertEquals("DEF地址", retrievedRestaurant.getAddress());
    }
}