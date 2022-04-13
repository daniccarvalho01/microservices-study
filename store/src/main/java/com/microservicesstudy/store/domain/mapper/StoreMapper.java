package com.microservicesstudy.store.domain.mapper;

import com.microservicesstudy.store.domain.entity.Store;
import com.microservicesstudy.store.domain.response.OrderResponse;
import com.microservicesstudy.store.domain.response.StoreResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreMapper {

    public StoreResponse toResponse(Store store) {
        StoreResponse storeResponse = new StoreResponse();

        storeResponse.setId(store.getId());
        storeResponse.setName(store.getName());

        return storeResponse;
    }

    public Store toEntity(StoreResponse response){
        Store store = new Store();

        store.setId(response.getId());
        store.setName(response.getName());

        return store;
    }

}
