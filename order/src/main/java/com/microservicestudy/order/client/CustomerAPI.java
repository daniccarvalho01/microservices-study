package com.microservicestudy.order.client;

import com.microservicestudy.order.domain.response.CustomerResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "customerAPI",  url = "${client.customer.url}")
@Cacheable(cacheNames = "customer", key = "#customerId")
public interface CustomerAPI {

    @GetMapping(value= "people/{customerId}")
    CustomerResponse findCustomer(@PathVariable Long customerId);
}
