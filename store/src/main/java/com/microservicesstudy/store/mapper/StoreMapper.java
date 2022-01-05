package com.microservicesstudy.store.mapper;

import com.microservicesstudy.store.entities.Store;
import com.microservicesstudy.store.response.StoreResponse;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {

    public StoreResponse toResponse(Store store) {
        StoreResponse storeResponse = new StoreResponse();

        storeResponse.setId(store.getId());
        storeResponse.setName(store.getName());

        return storeResponse;
    }
}
