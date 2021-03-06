package de.leuphana.shop.ordermicroservice.component.behaviour;

import de.leuphana.shop.customermicroservice.component.structure.Customer;
import de.leuphana.shop.ordermicroservice.component.structure.Order;
import de.leuphana.shop.ordermicroservice.connector.OrderDatabaseConnector;

public class OrderServiceImplementation implements OrderService {

    private OrderDatabaseConnector orderDatabaseConnector;

    public OrderServiceImplementation(OrderDatabaseConnector orderDatabaseConnector) {
        this.orderDatabaseConnector = orderDatabaseConnector;
    }

    @Override
    public Order createOrder(Customer customer, Cart cart) {
        Order order = new Order();
        order.setCart(cart);
        order.setCustomer(customer);
        order.setId(orderDatabaseConnector.createOrder(order));
        return order;
    }

    @Override
    public Order getOrder(Integer id) {
        return orderDatabaseConnector.getOrder(id);
    }

}
