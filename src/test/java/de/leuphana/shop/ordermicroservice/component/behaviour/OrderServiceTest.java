package de.leuphana.shop.ordermicroservice.component.behaviour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderServiceTest {

    private static OrderService orderService;
    private static ApplicationContext applicationContext;

    @BeforeAll
    static void beforeAll() {
        applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        orderService = (OrderService) applicationContext.getBean("orderServiceImplementation");
    }

    @Test
    void canOrderBeCreated() {

        Assertions.assertNotNull(orderService.createOrder(3, 2));

    }

    @Test
    void canOrderBeGotten() {
        Integer orderId = orderService.createOrder(5, 5).getOrderId();

        Assertions.assertNotNull(orderService.getOrder(orderId));

    }

}
