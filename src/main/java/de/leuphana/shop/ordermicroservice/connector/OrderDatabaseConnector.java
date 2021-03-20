package de.leuphana.shop.ordermicroservice.connector;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.transaction.annotation.Transactional;

import de.leuphana.shop.ordermicroservice.component.structure.Order;
import de.leuphana.shop.ordermicroservice.component.structure.OrderPosition;
import de.leuphana.shop.ordermicroservice.connector.entity.OrderEntity;
import de.leuphana.shop.ordermicroservice.connector.entity.OrderPositionEntity;
import de.leuphana.shop.ordermicroservice.connector.mapper.OrderMapper;
import de.leuphana.shop.ordermicroservice.connector.mapper.OrderPositionMapper;

public class OrderDatabaseConnector {
    private EntityManager entityManager;

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Integer createOrder(Order order) {
        OrderEntity orderEntity = OrderMapper.mapOrderToOrderEntity(order);
        entityManager.persist(orderEntity);
        return orderEntity.getId();
    }

    @Transactional
    public Order getOrder(Integer orderId) {
        OrderEntity orderEntity = entityManager.getReference(OrderEntity.class, orderId);
        return OrderMapper.mapOrderEntityToOrder(orderEntity);
    }

    @Transactional
    public List<Order> getOrders() {
        List<OrderEntity> orderEntities = entityManager.createQuery("FROM OrderEntity").getResultList();
        List<Order> orders = new LinkedList<>();
        for (OrderEntity orderEntity : orderEntities) {
            orders.add(OrderMapper.mapOrderEntityToOrder(orderEntity));
        }
        return orders;
    }

    @Transactional
    public OrderPosition createOrderPosition(OrderPosition orderPosition) {
        OrderPositionEntity orderPositionEntity = OrderPositionMapper
                .mapOrderPositionToOrderPositionEntity(orderPosition);
        entityManager.persist(orderPositionEntity);
        return OrderPositionMapper.mapOrderPositionEntityToOrderPosition(orderPositionEntity);
    }
}