package com.microservicesstudy.store.resource;

import com.microservicesstudy.store.domain.entity.Store;
import com.microservicesstudy.store.domain.mapper.StoreMapper;
import com.microservicesstudy.store.domain.request.StoreRequest;
import com.microservicesstudy.store.domain.response.StoreResponse;
import com.microservicesstudy.store.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/stores")
public class StoreResource {

    @Autowired
    StoreService service;

    @Autowired
    StoreMapper storeMapper;

    @GetMapping
    public ResponseEntity<List<StoreResponse>> findAll(){
        log.info("findAll, inicio da busca");

        List<StoreResponse> storeResponseList = service.findAll();

        return new ResponseEntity<>(storeResponseList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StoreResponse> findById(@PathVariable Long id){
        log.info("findById, inicio da busca, id={}", id);

        StoreResponse storeResponse = service.findById(id);

        return new ResponseEntity<>(storeResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StoreResponse> insert(@RequestBody StoreRequest request){
        log.info("insert, inicio da inserção, request={}", request);

        Store store = new Store();
        store.setName(request.getName());

        Store savedStore = service.insert(store);

        StoreResponse storeResponse = storeMapper.toResponse(savedStore);

        return new ResponseEntity<>(storeResponse, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StoreResponse> update(@PathVariable Long id,
                                                @RequestBody StoreRequest request){
        log.info("update, inicio da alteração, id={}", id);

        Store store = service.update(id, request);

        StoreResponse storeResponse = storeMapper.toResponse(store);

        return new ResponseEntity<>(storeResponse, HttpStatus.OK);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        log.info("delete, inicio da exclusão, id={}", id);

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
