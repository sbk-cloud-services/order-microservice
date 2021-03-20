package de.leuphana.shop.ordermicroservice.connector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.leuphana.shop.ordermicroservice.component.behaviour.OrderService;
import de.leuphana.shop.ordermicroservice.component.structure.Order;

@RestController
public class OrderRestController {

    @PostMapping("/orders")
    @ResponseBody
    public Order createOrder(@RequestBody Order order) {
        OrderService orderService = (OrderService) OrderServiceApplication.getApplicationContext()
                .getBean("orderServiceImplementation");
        return orderService.createOrder(order.getCustomerId(), order.getCartId());
    }

    @GetMapping("/orders/{id}")
    @ResponseBody
    public Order getOrder(@PathVariable Integer orderId) {
        OrderService orderService = (OrderService) OrderServiceApplication.getApplicationContext()
                .getBean("orderServiceImplementation");
        return orderService.getOrder(orderId);
    }

    @GetMapping("/orders")
    @ResponseBody
    public Order getOrders(@PathVariable Integer orderId) {
        OrderService orderService = (OrderService) OrderServiceApplication.getApplicationContext()
                .getBean("orderServiceImplementation");
        return orderService.getOrder(orderId);
    }
}