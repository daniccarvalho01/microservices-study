package com.microservicesstudy.store.domain.mapper;

import com.microservicesstudy.store.domain.entity.Store;
import com.microservicesstudy.store.domain.response.StoreResponse;
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
