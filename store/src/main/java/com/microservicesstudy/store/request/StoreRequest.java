package com.microservicesstudy.store.request;

import java.time.LocalDate;

public class StoreRequest {

    private String name;
    private LocalDate dateCreate;
    private LocalDate dateUpdate;

    public StoreRequest() {
    }

    public StoreRequest(String name, LocalDate dateCreate, LocalDate dateUpdate) {
        this.name = name;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDate getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDate dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
