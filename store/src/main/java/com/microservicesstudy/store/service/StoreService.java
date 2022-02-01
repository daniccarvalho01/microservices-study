package com.microservicesstudy.store.service;

import com.microservicesstudy.store.domain.entity.Store;
import com.microservicesstudy.store.repository.StoreRepository;
import com.microservicesstudy.store.domain.request.StoreRequest;
import com.microservicesstudy.store.domain.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService{

    @Autowired
    private StoreRepository repository;

    public Store insert(Store store){
        return repository.save(store);
    }

    public List<Store> findAll(){
        return repository.findAll();
    }

    public Store findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Store update(Long id, StoreRequest request){

        Store store = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        store.setName(request.getName());

        return repository.save(store);
    }

    public void delete(Long id){
        Store store = findById(id);

        repository.delete(store);
    }

}
