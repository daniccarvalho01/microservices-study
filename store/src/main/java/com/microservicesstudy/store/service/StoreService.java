package com.microservicesstudy.store.service;

import com.microservicesstudy.store.client.OrderClient;
import com.microservicesstudy.store.domain.entity.Store;
import com.microservicesstudy.store.domain.exception.ResourceNotFoundException;
import com.microservicesstudy.store.domain.mapper.StoreMapper;
import com.microservicesstudy.store.domain.request.StoreRequest;
import com.microservicesstudy.store.domain.response.OrderResponse;
import com.microservicesstudy.store.domain.response.StoreResponse;
import com.microservicesstudy.store.repository.StoreRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<StoreResponse> findAll() {
        List<Store> list = repository.findAll();

        List<StoreResponse> storeResponseList = new ArrayList<>();

        StoreResponse storeResponse = new StoreResponse();

        try{
            for (Store store : list) {
                storeResponse = storeMapper.toResponse(store);

                List<OrderResponse> orderResponseList = orderClient.findLastsByStore(store.getId());

                storeResponse.setOrders(orderResponseList);
                storeResponseList.add(storeResponse);
            }
        }catch (ResourceNotFoundException ex){
            throw new ResourceNotFoundException(storeResponse.getId());

        }

        return storeResponseList;
    }

    public StoreResponse findById(Long id){
        StoreResponse storeResponse = new StoreResponse();

        try{
            Store store =  repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(id));

            List<OrderResponse> orderResponseList = orderClient.findLastsByStore(store.getId());

            storeResponse = storeMapper.toResponse(store);
            storeResponse.setOrders(orderResponseList);

        } catch (ResourceNotFoundException ex){
            throw new ResourceNotFoundException(id);
        }

        return storeResponse;
    }

    public Store update(Long id, StoreRequest request){

        Store store = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        store.setName(request.getName());

        return repository.save(store);
    }

    public void delete(Long id){
        Store store = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        repository.delete(store);
    }

}
