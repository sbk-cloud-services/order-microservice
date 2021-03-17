package de.leuphana.shop.ordermicroservice.component.behaviour;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.leuphana.shop.ordermicroservice.component.structure.OrderPosition;

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
    void canOrderBeCreated() {
        Assertions.assertNotNull(orderService.createOrder(3, orderPositions));

    }

    @Test
    void canOrderBeGotten() {
        Integer orderId = orderService.createOrder(5, orderPositions).getOrderId();
        Assertions.assertNotNull(orderService.getOrder(orderId));
    }

    @Test
    void canOrdersBeFetched() {
        Assertions.assertNotNull(orderService.getOrders());
    }
    

}
