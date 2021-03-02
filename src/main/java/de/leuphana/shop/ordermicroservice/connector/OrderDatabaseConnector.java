package de.leuphana.shop.ordermicroservice.connector;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.transaction.annotation.Transactional;

import de.leuphana.shop.ordermicroservice.component.structure.Order;
import de.leuphana.shop.ordermicroservice.connector.entity.OrderEntity;
import de.leuphana.shop.ordermicroservice.connector.mapper.OrderMapper;

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
        public Order getOrder(Integer id) {
            OrderEntity orderEntity = entityManager.getReference(OrderEntity.class, id);
            return OrderMapper.mapOrderEntityToOrder(orderEntity);
        }
    }