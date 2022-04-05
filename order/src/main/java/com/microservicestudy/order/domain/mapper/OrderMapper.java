package com.microservicestudy.order.domain.mapper;

import com.microservicestudy.order.domain.entity.Order;
import com.microservicestudy.order.domain.entity.OrderItem;
import com.microservicestudy.order.domain.request.OrderItemRequest;
import com.microservicestudy.order.domain.request.OrderRequest;
import com.microservicestudy.order.domain.response.OrderItemResponse;
import com.microservicestudy.order.domain.response.OrderResponse;
import com.microservicestudy.order.domain.response.StoreResponse;

import java.util.ArrayList;

public class OrderMapper {

    public static OrderResponse toResponse(Order order, StoreResponse storeResponse) {
        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setId(order.getId());
        orderResponse.setStore(storeResponse);
        orderResponse.setAddress(order.getAddress());
        orderResponse.setItems(new ArrayList<>());

        order.getItems().forEach(item -> {
            OrderItemResponse orderItemResponse = OrderItemMapper.toResponse(item);
            orderResponse.getItems().add(orderItemResponse);
        });

        return orderResponse;
    }

    public static Order toEntity(OrderRequest request){
        Order order = new Order();

        order.setStore(request.getStore());
        order.setAddress(request.getAddress());

        order.setItems(new ArrayList<>());
        request.getItems().forEach(item -> {
            OrderItem orderItem = new OrderItem();

            orderItem.setOrder(order);
            orderItem.setProduct(item.getProduct());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(item.getPrice());

            order.getItems().add(orderItem);
        });

        return order;
    }
}
