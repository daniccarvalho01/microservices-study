package com.microservicestudy.order.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private Long store;
    private String address;
    private Long customerId;

    private List<OrderItemRequest> items;

}
