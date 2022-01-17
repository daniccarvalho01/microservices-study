package com.microservicestudy.order.resource;

import com.microservicestudy.order.domain.entity.OrderItem;
import com.microservicestudy.order.domain.request.AddOrderAndOrderItemRequest;
import com.microservicestudy.order.response.OrderItemResponse;
import com.microservicestudy.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    OrderService service;

    @PostMapping("/items/{product}")
    public ResponseEntity<OrderItemResponse> addItems(@PathVariable Integer product,
                                                      @RequestBody AddOrderAndOrderItemRequest request){

        OrderItem orderItem = service.addItem(product, request);


        return ResponseEntity<>(HttpStatus.OK);
    }
}
