package com.microservicesstudy.store.client;

import com.microservicesstudy.store.domain.response.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "orders",  url = "${client.order.url}")
public interface OrderClient {

    @GetMapping(value = "orders/stores/{storeId}")
    List<OrderResponse> findLastsByStore(@PathVariable Long storeId);

}
