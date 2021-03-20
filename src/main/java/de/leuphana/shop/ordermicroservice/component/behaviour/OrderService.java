package de.leuphana.shop.ordermicroservice.component.behaviour;

import java.util.List;

import de.leuphana.shop.ordermicroservice.component.structure.Order;
import de.leuphana.shop.ordermicroservice.component.structure.OrderPosition;

public interface OrderService {
    
    public Order createOrder(Integer customerId, List<OrderPosition> list);
    public Order getOrder(Integer orderId);
    public List<Order> getOrders();
}
