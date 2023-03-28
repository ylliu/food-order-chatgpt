import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.example.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class OrderControllerTest {
    private MockMvc mockMvc;

    @Mock
    private OrderManagementSystem orderManager;
    @Mock
    private MenuManagementSystem menuManagementSystem;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new OrderController(orderManager,menuManagementSystem)).build();
    }

    @Test
    public void testAddOrder() throws Exception {
        // 创建订单项
        Dish menuItem = new Dish("Burger", 10.0);
        OrderItem orderItem = new OrderItem(menuItem, 2);

        // 创建订单
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);
        Order order = new Order();
        order.setOrderItems(orderItems);

        System.out.println(order);
        // 设置模拟对象的行为
        when(orderManager.addOrder(any(Order.class))).thenReturn(order);

        // 执行请求
        MvcResult result = mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"items\": [{ \"name\": \"Burger\", \"quantity\": 2 }]}"))
                .andExpect(status().isOk())
                .andReturn();

        // 验证模拟对象的方法是否被调用
        verify(orderManager).addOrder(any(Order.class));

        // 捕获参数
        ArgumentCaptor<Order> captor = ArgumentCaptor.forClass(Order.class);
        verify(orderManager).addOrder(captor.capture());

        System.out.println(captor.getValue().getOrderItems());
        // 断言请求和参数是否正确
        assertEquals("{\"orderItems\":[{\"dish\":{\"name\":\"Burger\",\"price\":10.0},\"quantity\":2}]}", result.getResponse().getContentAsString());
        assertEquals("Burger", captor.getValue().getOrderItems().get(0).getDish().getName());
        assertEquals(2, captor.getValue().getOrderItems().get(0).getQuantity());
    }
}
