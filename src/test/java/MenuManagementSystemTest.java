import org.example.Dish;
import org.example.MenuManagementSystem;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MenuManagementSystemTest {
    @Test
    public void testAddDish() {
        MenuManagementSystem mms = new MenuManagementSystem();

        Dish dish = new Dish("糖醋排骨", 20.0);
        mms.addDish(dish);

        Dish retrievedDish = mms.getDishByName("糖醋排骨");
        assertEquals(dish, retrievedDish);
    }

    @Test
    public void testGetDishByName() {
        MenuManagementSystem mms = new MenuManagementSystem();

        Dish dish1 = new Dish("糖醋排骨", 20.0);
        Dish dish2 = new Dish("宫保鸡丁", 18.0);

        mms.addDish(dish1);
        mms.addDish(dish2);

        Dish retrievedDish = mms.getDishByName("糖醋排骨");
        assertEquals(dish1, retrievedDish);

        retrievedDish = mms.getDishByName("宫保鸡丁");
        assertEquals(dish2, retrievedDish);
    }



    @Test
    public void testDeleteDish() {
        MenuManagementSystem mms = new MenuManagementSystem();

        Dish dish1 = new Dish("糖醋排骨", 20.0);
        Dish dish2 = new Dish("宫保鸡丁", 18.0);

        mms.addDish(dish1);
        mms.addDish(dish2);

        mms.deleteDish(dish1);

        Dish retrievedDish = mms.getDishByName("糖醋排骨");
        assertNull(retrievedDish);
    }
}

