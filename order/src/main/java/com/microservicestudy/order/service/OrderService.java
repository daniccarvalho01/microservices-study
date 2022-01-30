package com.microservicestudy.order.service;

import com.microservicestudy.order.domain.entity.Order;
import com.microservicestudy.order.domain.entity.OrderItem;
import com.microservicestudy.order.domain.exception.ResourceNotFoundException;
import com.microservicestudy.order.domain.request.OrderItemRequest;
import com.microservicestudy.order.domain.request.OrderRequest;
import com.microservicestudy.order.repository.OrderItemRepository;
import com.microservicestudy.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderItemRepository itemRepository;


    public void create(OrderRequest request) {
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

        repository.save(order);
    }

    public Order findOrder(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return order;
    }

    public List<Order> findOrders() {

        return repository.findAll();
    }

    public void delete(Long id) {
        Order order = findOrder(id);
        repository.delete(order);
    }
}