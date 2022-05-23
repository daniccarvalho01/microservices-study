package com.microservicestudy.order.service;

import com.microservicestudy.order.domain.entity.Order;
import com.microservicestudy.order.domain.exception.ResourceNotFoundException;
import com.microservicestudy.order.domain.mapper.OrderMapper;
import com.microservicestudy.order.domain.request.OrderRequest;
import com.microservicestudy.order.domain.response.CustomerResponse;
import com.microservicestudy.order.domain.response.OrderResponse;
import com.microservicestudy.order.domain.response.StoreResponse;
import com.microservicestudy.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private StoreService storeService;

    @Autowired
    private CustomerService customerService;


    public void create(OrderRequest request) {
        Order order = OrderMapper.toEntity(request);

        repository.save(order);
    }

    public OrderResponse findOrder(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        StoreResponse storeResponse = storeService.findStore(order);

        CustomerResponse customerResponse = customerService.getCustomer(order.getCustomerId());

        OrderResponse orderResponse = OrderMapper.toResponse(order, storeResponse, customerResponse);

        return orderResponse;
    }

    public List<OrderResponse> findOrders() {

        List<Order> list = repository.findAll();

        List<OrderResponse> orderResponseList = new ArrayList<>();

        for(Order order : list) {

            StoreResponse storeResponse = storeService.findStore(order);

            CustomerResponse customerResponse = customerService.getCustomer(order.getCustomerId());

            OrderResponse orderResponse = OrderMapper.toResponse(order, storeResponse, customerResponse);

            orderResponseList.add(orderResponse);
        }

        return orderResponseList;
    }

    public void delete(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        repository.delete(order);
    }

    public List<OrderResponse> findOrdersByStore(Long storeId) {
        PageRequest pageRequest = PageRequest.of(0,2, Sort.by(Sort.Direction.DESC, "date"));
        List<Order> list = repository.getOrdersByStore(storeId, pageRequest);

        List<OrderResponse> orderResponseList = new ArrayList<>();

        for(Order order : list) {
            CustomerResponse customerResponse = customerService.getCustomer(order.getCustomerId());

            OrderResponse orderResponse = OrderMapper.toResponse(order, customerResponse);

            orderResponseList.add(orderResponse);
        }

        return orderResponseList;
    }
}