package de.leuphana.shop.ordermicroservice.component.behaviour;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.leuphana.shop.ordermicroservice.component.structure.OrderPosition;

@TestMethodOrder(OrderAnnotation.class)
public class OrderServiceTest {

    private static OrderService orderService;
    private static ApplicationContext applicationContext;
    private static List<OrderPosition> orderPositions;

    @BeforeAll
    static void beforeAll() {
        orderPositions = new ArrayList<OrderPosition>();
        OrderPosition orderPosition = new OrderPosition();
        orderPosition.setArticleId(1);
        orderPosition.setQuantity(3);
        orderPositions.add(orderPosition);

        applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        orderService = (OrderService) applicationContext.getBean("orderServiceImplementation");
    }

    @Test
    @Order(1)
    void canOrderBeCreated() {
        Assertions.assertNotNull(orderService.createOrder(3, orderPositions));

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
