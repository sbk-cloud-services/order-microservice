package de.leuphana.shop.ordermicroservice.component.behaviour;

import de.leuphana.shop.ordermicroservice.component.structure.Order;
import de.leuphana.shop.ordermicroservice.connector.OrderDatabaseConnector;

public class OrderServiceImplementation implements OrderService {

    private OrderDatabaseConnector orderDatabaseConnector;

    public OrderServiceImplementation(OrderDatabaseConnector orderDatabaseConnector) {
        this.orderDatabaseConnector = orderDatabaseConnector;
    }

    @Override
    public Order createOrder(Integer customerId, Integer cartId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Order getOrder(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }


}
