package com.microservicesstudy.store.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<OrderResponse> orders;

}
