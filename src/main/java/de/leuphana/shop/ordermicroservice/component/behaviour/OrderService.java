package de.leuphana.shop.ordermicroservice.component.behaviour;

import de.leuphana.shop.customermicroservice.component.structure.Customer;
import de.leuphana.shop.ordermicroservice.component.structure.Order;

public interface OrderService {
    
    public Order createOrder(Customer customer, Cart cart); //TODO: #9 Replace Customer and Cart objects with customerId and cartId
    public Order getOrder(Integer id);
}
