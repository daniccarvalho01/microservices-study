package com.microservicestudy.order.resource;

import com.microservicestudy.order.domain.request.OrderRequest;
import com.microservicestudy.order.domain.response.OrderResponse;
import com.microservicestudy.order.service.CustomerService;
import com.microservicestudy.order.service.OrderService;
import com.microservicestudy.order.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    OrderService service;

    @Autowired
    StoreService storeService;

    @Autowired
    CustomerService customerService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderRequest request){
        log.info("create, inicio da inserção, request={}", request);

        service.create(request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long id) {
        log.info("findById, inicio da busca, id={}", id);

        OrderResponse orderResponse = service.findOrder(id);

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findOrders(){
        log.info("findOrders, inicio da busca");

        List<OrderResponse> orderResponseList = service.findOrders();

        return new ResponseEntity<>(orderResponseList, HttpStatus.OK);
    }

    @GetMapping("/stores/{storeId}")
    public ResponseEntity<List<OrderResponse>> findOrdersByStore(@PathVariable Long storeId){
        log.info("findOrdersByStore, inicio da busca, id={}", storeId);

        List<OrderResponse> list = service.findOrdersByStore(storeId);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<OrderResponse> removeById(@PathVariable Long id){
        log.info("removeById, inicio da exclusão, id={}", id);

        service.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
