package com.microservicestudy.order.service;

import com.microservicestudy.order.domain.entity.Order;
import com.microservicestudy.order.domain.entity.OrderItem;
import com.microservicestudy.order.domain.request.AddOrderAndOrderItemRequest;
import com.microservicestudy.order.repository.OrderItemRepository;
import com.microservicestudy.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderItemRepository itemRepository;

    public OrderItem addItem(Integer product, AddOrderAndOrderItemRequest request){

        Order order = new Order();
        order.setStore(request.getStore());
        order.setAddress(request.getAddress());
        repository.save(order);

        OrderItem orderItem = new OrderItem();



        return itemRepository.save(orderItem);

    }
}