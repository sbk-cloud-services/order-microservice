package de.leuphana.shop.ordermicroservice.component.structure;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Integer id;
    private List<OrderPosition> orderPositions;
    private Integer customerId;

    public Order() {
        this.orderPositions = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(List<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

}
