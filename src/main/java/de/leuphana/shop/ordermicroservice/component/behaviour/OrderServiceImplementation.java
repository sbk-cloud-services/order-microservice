package de.leuphana.shop.ordermicroservice.component.behaviour;

import de.leuphana.shop.customermicroservice.component.structure.Customer;
import de.leuphana.shop.ordermicroservice.component.structure.Order;
import de.leuphana.shop.ordermicroservice.connector.OrderDatabaseConnector;

public class OrderServiceImplementation implements OrderService {

    private static OrderServiceImplementation orderServiceImplementation;
    private OrderDatabaseConnector orderDatabaseConnector;

    public static OrderService getInstance() {
        if(orderServiceImplementation == null) orderServiceImplementation = new OrderServiceImplementation();
        return orderServiceImplementation;
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

    @Override
    public void setOrderDatabaseConnector(OrderDatabaseConnector orderDatabaseConnector) {
        this.orderDatabaseConnector = orderDatabaseConnector;
    }    
}
