package de.leuphana.shop.ordermicroservice.connector.mapper;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import de.leuphana.shop.ordermicroservice.component.structure.Order;
import de.leuphana.shop.ordermicroservice.connector.entity.OrderEntity;


public class OrderMapper {
    private static Mapper mapper;

    static {
        mapper = DozerBeanMapperSingletonWrapper.getInstance();
    }

    public static OrderEntity mapOrderToOrderEntity(Order order) {
        return mapper.map(order, OrderEntity.class);
    }

    public static Order mapOrderEntityToOrder(OrderEntity orderEntity) {
        return mapper.map(orderEntity, Order.class);
    }
}