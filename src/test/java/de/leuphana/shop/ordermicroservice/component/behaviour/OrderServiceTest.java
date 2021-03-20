package de.leuphana.shop.ordermicroservice.component.behaviour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@TestMethodOrder(OrderAnnotation.class)
public class OrderServiceTest {

    private static OrderService orderService;
    private static ApplicationContext applicationContext;

    @BeforeAll
    static void beforeAll() {
        applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        orderService = (OrderService) applicationContext.getBean("orderServiceImplementation");
    }

    @Test
    @Order(1)
    void canOrderBeCreated() {
        Assertions.assertNotNull(orderService.createOrder(3, 2));

    }

    @Test
    @Order(2)
    void canOrderBeFetched() {
        Integer orderId = orderService.createOrder(5, 5).getOrderId();
        Assertions.assertNotNull(orderService.getOrder(orderId));
    }

    @Test
    @Order(3)
    void canOrdersBeFetched() {
        Assertions.assertNotNull(orderService.getOrders());
    }

}
