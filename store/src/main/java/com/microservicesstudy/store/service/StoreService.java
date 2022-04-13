package com.microservicesstudy.store.service;

import com.microservicesstudy.store.client.OrderClient;
import com.microservicesstudy.store.domain.entity.Store;
import com.microservicesstudy.store.domain.exception.ResourceNotFoundException;
import com.microservicesstudy.store.domain.mapper.StoreMapper;
import com.microservicesstudy.store.domain.request.StoreRequest;
import com.microservicesstudy.store.domain.response.OrderResponse;
import com.microservicesstudy.store.domain.response.StoreResponse;
import com.microservicesstudy.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService{

    @Autowired
    private StoreRepository repository;

    @Autowired
    private OrderClient orderClient;

    @Autowired
    StoreMapper storeMapper;

    public Store insert(Store store){
        return repository.save(store);
    }

    public List<Store> findAll(){

        return repository.findAll();
    }

    public StoreResponse findById(Long id){
        Store store =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        List<OrderResponse> orderResponseList = orderClient.findLastOrdersByStore(store.getId());

        StoreResponse storeResponse = storeMapper.toResponse(store);
        storeResponse.setOrders(orderResponseList);

        return storeResponse;
    }

    public Store update(Long id, StoreRequest request){

        Store store = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        store.setName(request.getName());

        return repository.save(store);
    }

    public void delete(Long id){
        StoreResponse storeResponse = findById(id);

        Store store = storeMapper.toEntity(storeResponse);

        repository.delete(store);
    }

}
