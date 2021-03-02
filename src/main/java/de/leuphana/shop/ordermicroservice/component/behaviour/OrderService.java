package de.leuphana.shop.ordermicroservice.component.behaviour;

import de.leuphana.shop.customermicroservice.component.structure.Customer;
import de.leuphana.shop.ordermicroservice.component.structure.Order;
import de.leuphana.shop.ordermicroservice.connector.OrderDatabaseConnector;

public interface OrderService {
    
    public Order createOrder(Customer customer, Cart cart);
    public Order getOrder(Integer id);
    public void setOrderDatabaseConnector(OrderDatabaseConnector orderDatabaseConnector);
}
