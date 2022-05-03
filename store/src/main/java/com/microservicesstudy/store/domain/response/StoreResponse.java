package com.microservicesstudy.store.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreResponse {

    private Long id;
    private String name;
    private List<OrderResponse> orders;

}
