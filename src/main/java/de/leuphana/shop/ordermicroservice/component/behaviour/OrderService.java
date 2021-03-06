package de.leuphana.shop.ordermicroservice.component.behaviour;

import de.leuphana.shop.ordermicroservice.component.structure.Order;

public interface OrderService {
    
    public Order createOrder(Integer customerId, Integer cartId);
    public Order getOrder(Integer id);
}
