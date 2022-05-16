package com.microservicesstudy.store.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long id;
    private CustomerResponse customer;
    private String address;

    private List<OrderItemResponse> items;

}
