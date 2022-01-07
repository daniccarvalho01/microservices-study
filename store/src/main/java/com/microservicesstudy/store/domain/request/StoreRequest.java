package com.microservicesstudy.store.domain.request;

import java.time.LocalDate;

public class StoreRequest {

    private String name;


    public StoreRequest() {
    }

    public StoreRequest(String name, LocalDate dateCreate, LocalDate dateUpdate) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
