package de.leuphana.shop.ordermicroservice.component.structure;

import de.leuphana.shop.customermicroservice.component.structure.Customer;

public class Order {

    private Integer id;
    private Cart cart;
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
