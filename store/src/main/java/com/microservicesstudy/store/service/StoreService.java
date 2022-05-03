package com.microservicesstudy.store.service;

import com.microservicesstudy.store.client.OrderClient;
import com.microservicesstudy.store.domain.entity.Store;
import com.microservicesstudy.store.domain.exception.ResourceNotFoundException;
import com.microservicesstudy.store.domain.mapper.StoreMapper;
import com.microservicesstudy.store.domain.request.StoreRequest;
import com.microservicesstudy.store.domain.response.OrderResponse;
import com.microservicesstudy.store.domain.response.StoreResponse;
import com.microservicesstudy.store.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StoreService{

    @Autowired
    private StoreRepository repository;

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private StoreMapper storeMapper;

    public Store insert(Store store){
        return repository.save(store);
    }

    public List<StoreResponse> findAll() {
        List<Store> list = repository.findAll();

        List<StoreResponse> storeResponseList = new ArrayList<>();

        for (Store store : list) {
            StoreResponse storeResponse = storeMapper.toResponse(store);

            storeResponse.setOrders(findLastOrdersByStore(store.getId()));

            storeResponseList.add(storeResponse);
        }

        return storeResponseList;
    }

    public StoreResponse findById(Long id){
        Store store =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        StoreResponse storeResponse = storeMapper.toResponse(store);

        storeResponse.setOrders(findLastOrdersByStore(store.getId()));

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

    private List<OrderResponse> findLastOrdersByStore(Long storeId) {
        try {
            return orderClient.findLastsByStore(storeId);
        } catch (Exception ex){
            log.warn("findAll, Erro ao buscar as ultimas ordens, storeId={}", storeId);
            return null;
        }
    }

}
