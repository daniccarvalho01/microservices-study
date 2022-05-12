package com.microservicestudy.order.client;

import com.microservicestudy.order.domain.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "customerAPI",  url = "${client.order.url}")
public interface CustomerAPI {

    @GetMapping(value= "people/{clientId}")
    CustomerResponse findCustomer(@PathVariable Long clientId);
}
