package com.microservicesstudy.store.services;

import com.microservicesstudy.store.entities.Store;
import com.microservicesstudy.store.repositories.StoreRepository;
import com.microservicesstudy.store.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository repository;

    public Store insert(Store store){
        return repository.save(store);
    }

    public List<Store> findAll(){
        return repository.findAll();
    }

    public Store findById(Long id){
        Optional<Store> store = repository.findById(id);
        return store.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Store update(Long id){
        Optional<Store> optionalStore = repository.findById(id);
        optionalStore.orElseThrow(() -> new ResourceNotFoundException(id));
        Store store = optionalStore.get();

        return repository.save(store);
    }

}
