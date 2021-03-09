package de.leuphana.shop.ordermicroservice.connector;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.leuphana.shop.ordermicroservice.component.behaviour.OrderService;
import de.leuphana.shop.ordermicroservice.component.structure.Order;

@RestController
public class OrderRestController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @PostMapping("/orders")
    @ResponseBody
    public Order createOrder(@RequestBody Order order) {

        return getOrderServiceFromApplicationContext().createOrder(order.getCustomerId(), order.getCartId());
    }

    @GetMapping("/orders/{orderId}")
    @ResponseBody
    public Order getOrder(@PathVariable("id") Integer orderId) {
        return getOrderServiceFromApplicationContext().getOrder(orderId);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }

    private OrderService getOrderServiceFromApplicationContext() {
        return (OrderService) applicationContext.getBean("orderServiceImplementation");
    }
}