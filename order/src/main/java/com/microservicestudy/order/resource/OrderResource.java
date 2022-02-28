package com.microservicestudy.order.resource;

import com.microservicestudy.order.domain.entity.Order;
import com.microservicestudy.order.domain.exception.ResourceNotFoundException;
import com.microservicestudy.order.domain.mapper.OrderMapper;
import com.microservicestudy.order.domain.request.OrderRequest;
import com.microservicestudy.order.domain.response.OrderResponse;
import com.microservicestudy.order.domain.response.StoreResponse;
import com.microservicestudy.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    OrderService service;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderRequest request){
        service.create(request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long id) {
        Order order = service.findOrder(id);

        StoreResponse storeResponse;
        try {
            RestTemplate restTemplate = new RestTemplate();

            String storeResourceUrl = "http://localhost:8080/stores/{id}";

            ResponseEntity<StoreResponse> storeResponseEntity =
                    restTemplate.getForEntity(storeResourceUrl,
                            StoreResponse.class, order.getStore());

            storeResponse = storeResponseEntity.getBody();

        } catch (Exception ex) {
            storeResponse = new StoreResponse();
            storeResponse.setId(order.getStore());
        }

        OrderResponse orderResponse = OrderMapper.toResponse(order, storeResponse);

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findOrders(){
        List<Order> list = service.findOrders();

        List<OrderResponse> orderResponseList = new ArrayList<>();

        for(Order order : list){
            OrderResponse storeResponse = OrderMapper.toResponse(order, null);// TODO CORRIGIR

            orderResponseList.add(storeResponse);
        }

        return new ResponseEntity<>(orderResponseList, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<OrderResponse> removeById(@PathVariable Long id){
         service.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
