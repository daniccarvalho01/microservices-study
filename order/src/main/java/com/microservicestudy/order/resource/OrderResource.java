package com.microservicestudy.order.resource;

import com.microservicestudy.order.domain.entity.Order;
import com.microservicestudy.order.domain.mapper.OrderMapper;
import com.microservicestudy.order.domain.request.OrderRequest;
import com.microservicestudy.order.domain.response.OrderResponse;
import com.microservicestudy.order.domain.response.StoreResponse;
import com.microservicestudy.order.service.OrderService;
import com.microservicestudy.order.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    OrderService service;

    @Autowired
    StoreService storeService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderRequest request){
        service.create(request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long id) {
        Order order = service.findOrder(id);

        StoreResponse storeResponse = storeService.findStore(order);

        OrderResponse orderResponse = OrderMapper.toResponse(order, storeResponse);

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findOrders(){
        List<Order> list = service.findOrders();

        List<OrderResponse> orderResponseList = new ArrayList<>();

        for(Order order : list) {

            StoreResponse storeResponse = storeService.findStore(order);

            OrderResponse orderResponse = OrderMapper.toResponse(order, storeResponse);

            orderResponseList.add(orderResponse);
            }



        return new ResponseEntity<>(orderResponseList, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<OrderResponse> removeById(@PathVariable Long id){
         service.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
