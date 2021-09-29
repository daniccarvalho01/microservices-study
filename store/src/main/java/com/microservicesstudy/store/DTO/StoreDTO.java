package com.microservicesstudy.store.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class StoreDTO implements Serializable {

    private Long id;
    private String name;
    private LocalDate dateCreate;
    private LocalDate dateUpdate;

    public StoreDTO() {
    }

    public StoreDTO(Long id, String name, LocalDate dateCreate, LocalDate dateUpdate) {
        this.id = id;
        this.name = name;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
