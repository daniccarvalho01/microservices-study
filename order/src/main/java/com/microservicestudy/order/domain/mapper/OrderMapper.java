package com.microservicestudy.order.domain.mapper;

import com.microservicestudy.order.domain.entity.Order;
import com.microservicestudy.order.domain.entity.OrderItem;
import com.microservicestudy.order.response.OrderItemResponse;
import com.microservicestudy.order.response.OrderResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class OrderMapper {

    public static OrderResponse toResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setStore(order.getStore());
        orderResponse.setAddress(order.getAddress());
        orderResponse.setItems(new ArrayList<>());
        for (OrderItem item : order.getItems()) {

            OrderItemResponse orderItemResponse = OrderItemMapper.toResponse(item);
            orderResponse.getItems().add(orderItemResponse);
        }

        return orderResponse;
    }
}
