package com.microservicestudy.order.service;

import com.microservicestudy.order.domain.entity.Order;
import com.microservicestudy.order.domain.exception.ResourceNotFoundException;
import com.microservicestudy.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order findById(Long id){
        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return order;
    }

    public List<Order> findAll(){

        return repository.findAll();
    }

    public Order insert(Order order){

        return repository.save(order);
    }

    public void delete(Long id){
        Order order = findById(id);

        repository.save(order);
    }
}