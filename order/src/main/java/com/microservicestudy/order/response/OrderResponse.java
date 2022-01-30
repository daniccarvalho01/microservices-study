package com.microservicestudy.order.response;


import java.util.List;

public class OrderResponse {

    private Long store;
    private String address;

    private List<OrderItemResponse> items;

    public OrderResponse() {
    }

    public OrderResponse(Long store, String address, List<OrderItemResponse> items) {
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

    public List<OrderItemResponse> getItems() {
        return items;
    }

    public void setItems(List<OrderItemResponse> items) {
        this.items = items;
    }
}
