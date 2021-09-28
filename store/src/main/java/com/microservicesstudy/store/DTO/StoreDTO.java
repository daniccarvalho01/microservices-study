package com.microservicesstudy.store.DTO;

import java.io.Serializable;
import java.util.Date;

public class StoreDTO implements Serializable {

    private Long id;
    private String name;
    private Date dateCreate;
    private Date dateUpdate;

    public StoreDTO() {
    }

    public StoreDTO(Long id, String name, Date dateCreate, Date dateUpdate) {
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

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
