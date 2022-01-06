package com.microservicesstudy.store.services;

import com.microservicesstudy.store.entities.Store;
import com.microservicesstudy.store.repositories.StoreRepository;
import com.microservicesstudy.store.request.StoreRequest;
import com.microservicesstudy.store.services.exceptions.ResourceNotFoundException;
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

//        Optional<Store> optionalStore = repository.findById(id);
//        optionalStore.orElseThrow(() -> new ResourceNotFoundException(id));
//
//        Store store = optionalStore.get();

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
