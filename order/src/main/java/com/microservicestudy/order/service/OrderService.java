package com.microservicestudy.order.service;

import com.microservicestudy.order.domain.entity.Order;
import com.microservicestudy.order.domain.exception.ResourceNotFoundException;
import com.microservicestudy.order.domain.mapper.OrderMapper;
import com.microservicestudy.order.domain.request.OrderRequest;
import com.microservicestudy.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;


    public void create(OrderRequest request) {
        Order order = OrderMapper.toEntity(request);

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

    public List<Order> findOrdersByStore(Long storeId) {
        PageRequest pageRequest = PageRequest.of(0,2);
        List<Order> orderList = repository.getOrdersByStore(storeId, pageRequest);

        return orderList;
    }

}