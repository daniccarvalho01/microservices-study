package com.microservicestudy.order.domain.request;

public class OrderRequest {

    private Integer store;
    private String address;

    public OrderRequest() {
    }

    public OrderRequest(Integer store, String address) {
        this.store = store;
        this.address = address;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
