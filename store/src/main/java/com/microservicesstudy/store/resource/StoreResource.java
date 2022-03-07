package com.microservicesstudy.store.resource;

import com.microservicesstudy.store.domain.entity.Store;
import com.microservicesstudy.store.domain.mapper.StoreMapper;
import com.microservicesstudy.store.domain.request.StoreRequest;
import com.microservicesstudy.store.domain.response.StoreResponse;
import com.microservicesstudy.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/stores")
public class StoreResource {

    @Autowired
    StoreService service;

    @Autowired
    StoreMapper storeMapper;

    //ok
    @GetMapping
    public ResponseEntity<List<StoreResponse>> findAll(){
        List<Store> list = service.findAll();

        List<StoreResponse> storeResponseList = new ArrayList<>();

        for(Store store : list){
            StoreResponse storeResponse = storeMapper.toResponse(store);

            storeResponseList.add(storeResponse);
        }

//        java8
//        storeResponseList = list.stream()
//                .map(store -> storeMapper.toResponse(store))
//                .collect(Collectors.toList());

        return new ResponseEntity<>(storeResponseList, HttpStatus.OK);
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
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
