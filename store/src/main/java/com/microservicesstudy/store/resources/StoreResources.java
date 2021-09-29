package com.microservicesstudy.store.resources;

import com.microservicesstudy.store.entities.Store;
import com.microservicesstudy.store.request.StoreRequest;
import com.microservicesstudy.store.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/stories")
public class StoreResources {

    @Autowired
    StoreService service;

    //ok
    @GetMapping
    public ResponseEntity<List<Store>> findAll(){
        List<Store> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //ok
    @GetMapping(value = "/{id}")
    public ResponseEntity<Store> findById(@PathVariable Long id){
        Store store = service.findById(id);
        return new ResponseEntity<>(store, HttpStatus.OK);
    }

    //ok
    @PostMapping
    public ResponseEntity<Store> insert(@RequestBody Store store){
        service.insert(store);
        return new ResponseEntity<>(store, HttpStatus.CREATED);
    }

    //ok
    @PutMapping(value = "/{id}")
    public ResponseEntity<Store> update(@PathVariable Long id, @RequestBody StoreRequest request){
        Store store = service.update(id, request);
        return new ResponseEntity<>(store, HttpStatus.OK);
    }

    //ok
    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
