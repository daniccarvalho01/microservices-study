package com.microservicestudy.order.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {

    private Integer product;
    private Integer quantity;
    private Double price;

}
