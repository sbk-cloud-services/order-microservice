package de.leuphana.shop.ordermicroservice.connector.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderPositionEntity> orderPositions;
    private Integer customerId;

    public OrderEntity() {
        this.orderPositions = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<OrderPositionEntity> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(List<OrderPositionEntity> orderPositions) {
        this.orderPositions = orderPositions;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

}
