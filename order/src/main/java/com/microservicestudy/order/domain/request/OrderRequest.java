package com.microservicestudy.order.domain.request;


import java.util.List;


public class OrderRequest {

    private Long store;
    private String address;

    private List<OrderItemRequest> items;

    public OrderRequest() {
    }

    public OrderRequest(Long store, String address, List<OrderItemRequest> items) {
        this.store = store;
        this.address = address;
        this.items = items;
    }

    public Long getStore() {
        return store;
    }

    public void setStore(Long store) {
        this.store = store;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}
