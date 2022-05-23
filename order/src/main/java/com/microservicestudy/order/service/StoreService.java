package com.microservicestudy.order.service;

import com.microservicestudy.order.domain.entity.Order;
import com.microservicestudy.order.domain.response.StoreResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StoreService {

    public StoreResponse findStore(Order order) {

        StoreResponse storeResponse;
        try {
            RestTemplate restTemplate = new RestTemplate();

            String storeResourceUrl = "http://localhost:8080/stores/{id}";

            ResponseEntity<StoreResponse> storeResponseEntity =
                    restTemplate.getForEntity(storeResourceUrl,
                            StoreResponse.class, order.getStore());

            storeResponse = storeResponseEntity.getBody();

        } catch (Exception ex) {
            storeResponse = new StoreResponse();
            storeResponse.setId(order.getStore());
        }

        return storeResponse;
    }
}
