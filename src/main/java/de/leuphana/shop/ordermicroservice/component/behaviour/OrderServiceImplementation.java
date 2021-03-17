package de.leuphana.shop.ordermicroservice.component.behaviour;

import java.util.List;

import de.leuphana.shop.ordermicroservice.component.structure.Order;
import de.leuphana.shop.ordermicroservice.component.structure.OrderPosition;
import de.leuphana.shop.ordermicroservice.connector.OrderDatabaseConnector;

public class OrderServiceImplementation implements OrderService {

    private OrderDatabaseConnector orderDatabaseConnector;

    public OrderServiceImplementation(OrderDatabaseConnector orderDatabaseConnector) {
        this.orderDatabaseConnector = orderDatabaseConnector;
    }

    @Override
    public Order createOrder(Integer customerId, List<OrderPosition> orderPositions) {
        Order order = new Order();

        order.setOrderPositions(orderPositions);
        order.setCustomerId(customerId);
        order.setOrderId(orderDatabaseConnector.createOrder(order));

        return order;
    }

    @Override
    public Order getOrder(Integer orderId) {
        return orderDatabaseConnector.getOrder(orderId);
    }

    @Override
    public List<Order> getOrders() {
        return orderDatabaseConnector.getOrders();
    }
}
