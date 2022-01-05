package com.microservicesstudy.store.resources;

import com.microservicesstudy.store.entities.Store;
import com.microservicesstudy.store.mapper.StoreMapper;
import com.microservicesstudy.store.request.StoreRequest;
import com.microservicesstudy.store.response.StoreResponse;
import com.microservicesstudy.store.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/stories")
public class StoreResources {

    @Autowired
    StoreService service;

    @Autowired
    StoreMapper storeMapper;

    //ok
    @GetMapping
    public ResponseEntity<List<Store>> findAll(){
        List<Store> list = service.findAll();

//        List<StoreResponse> storeResponseList = new ArrayList<>();
//
//        for(Store store : list){
//
//        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //ok
    @GetMapping(value = "/{id}")
    public ResponseEntity<StoreResponse> findById(@PathVariable Long id){
        Store store = service.findById(id);

        StoreResponse storeResponse = storeMapper.toResponse(store);

        return new ResponseEntity<>(storeResponse, HttpStatus.OK);
    }

    //ok
    @PostMapping
    public ResponseEntity<StoreResponse> insert(@RequestBody StoreRequest request){
        Store store = new Store();
        store.setName(request.getName());

        Store savedStore = service.insert(store);

        StoreResponse storeResponse = storeMapper.toResponse(savedStore);

        return new ResponseEntity<>(storeResponse, HttpStatus.CREATED);
    }

    //ok
    @PutMapping(value = "/{id}")
    public ResponseEntity<StoreResponse> update(@PathVariable Long id,
                                                @RequestBody StoreRequest request){
        Store store = service.update(id, request);

        StoreResponse storeResponse = storeMapper.toResponse(store);

        return new ResponseEntity<>(storeResponse, HttpStatus.OK);
    }

    //ok
    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
