package com.microservicesstudy.store.resources;

import com.microservicesstudy.store.entities.Store;
import com.microservicesstudy.store.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/stories")
public class StoreResources {

    @Autowired
    StoreService service;

    @GetMapping
    public ResponseEntity<List<Store>> findAll(){
        List<Store> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/id")
    public ResponseEntity<Store> findById(@PathVariable Long id){
        Store store = service.findById(id);
        return ResponseEntity.ok().body(store);
    }
}
