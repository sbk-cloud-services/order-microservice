package de.leuphana.shop.ordermicroservice.connector.mapper;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import de.leuphana.shop.ordermicroservice.component.structure.OrderPosition;
import de.leuphana.shop.ordermicroservice.connector.entity.OrderPositionEntity;


public class OrderPositionMapper {
    private static Mapper mapper;

    static {
        mapper = DozerBeanMapperSingletonWrapper.getInstance();
    }

    public static OrderPositionEntity mapOrderPositionToOrderPositionEntity(OrderPosition orderPosition) {
        return mapper.map(orderPosition, OrderPositionEntity.class);
    }

    public static OrderPosition mapOrderPositionEntityToOrderPosition(OrderPositionEntity orderPositionEntity) {
        return mapper.map(orderPositionEntity, OrderPosition.class);
    }
}