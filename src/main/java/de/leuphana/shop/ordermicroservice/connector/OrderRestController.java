package de.leuphana.shop.ordermicroservice.connector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.leuphana.shop.customermicroservice.component.behaviour.CustomerService;
import de.leuphana.shop.customermicroservice.component.behaviour.CustomerServiceImplementation;
import de.leuphana.shop.customermicroservice.component.structure.Customer;
import de.leuphana.shop.ordermicroservice.component.behaviour.OrderService;
import de.leuphana.shop.ordermicroservice.component.behaviour.OrderServiceImplementation;
import de.leuphana.shop.ordermicroservice.component.structure.Order;

@RestController
public class OrderRestController {

    @PostMapping("/orders")
    @ResponseBody
    public Order createOrder(@RequestBody Order order) {
        CustomerService customerService = CustomerServiceImplementation.getInstance();
        Customer customer = customerService.getCustomer(order.getId());

        // TODO Cart 
        OrderService orderService = OrderServiceImplementation.getInstance();
        return orderService.createOrder(customer);
    }

    @GetMapping("/orders/{id}")
    @ResponseBody
    public Order getOrder(@PathVariable("id") Integer id) {
        return OrderServiceImplementation.getInstance().getOrder(id);
    }
}