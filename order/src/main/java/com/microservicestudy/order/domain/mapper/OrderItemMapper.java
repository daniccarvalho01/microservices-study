package com.microservicestudy.order.domain.mapper;

import com.microservicestudy.order.domain.entity.OrderItem;
import com.microservicestudy.order.domain.response.OrderItemResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public static OrderItemResponse toResponse(OrderItem orderItem) {
        OrderItemResponse orderItemResponse = new OrderItemResponse();

        orderItemResponse.setPrice(orderItem.getPrice());
        orderItemResponse.setQuantity(orderItem.getQuantity());
        orderItemResponse.setProduct(orderItem.getProduct());
        return orderItemResponse;
    }
}
