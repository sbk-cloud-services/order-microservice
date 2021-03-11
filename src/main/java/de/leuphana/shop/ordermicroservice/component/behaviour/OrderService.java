package de.leuphana.shop.ordermicroservice.component.behaviour;

import java.util.List;

import de.leuphana.shop.ordermicroservice.component.structure.Order;

public interface OrderService {
    
    public Order createOrder(Integer customerId, Integer cartId);
    public Order getOrder(Integer orderId);
    public List<Order> getOrders();
}
