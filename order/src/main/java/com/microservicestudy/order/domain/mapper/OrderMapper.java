package com.microservicestudy.order.domain.mapper;

import com.microservicestudy.order.domain.entity.Order;
import com.microservicestudy.order.domain.entity.OrderItem;
import com.microservicestudy.order.domain.request.OrderItemRequest;
import com.microservicestudy.order.domain.request.OrderRequest;
import com.microservicestudy.order.response.OrderItemResponse;
import com.microservicestudy.order.response.OrderResponse;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;


public class OrderMapper {

    @Bean
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

    @Bean
    public static Order toEntity(OrderRequest request){
        Order order = new Order();

        order.setStore(request.getStore());
        order.setAddress(request.getAddress());

        order.setItems(new ArrayList<>());
        for (OrderItemRequest item : request.getItems()) {
            OrderItem orderItem = new OrderItem();

            orderItem.setOrder(order);
            orderItem.setProduct(item.getProduct());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(item.getPrice());

            order.getItems().add(orderItem);
        }

        return order;
    }
}
