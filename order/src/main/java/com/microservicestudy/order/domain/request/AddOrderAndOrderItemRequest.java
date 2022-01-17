package com.microservicestudy.order.domain.request;

public class AddOrderAndOrderItemRequest {

    private Long store;
    private String address;
    private Integer product;
    private Integer quantity;
    private Double price;

    public AddOrderAndOrderItemRequest() {
    }

    public AddOrderAndOrderItemRequest(Long store, String address, Integer product, Integer quantity, Double price) {
        this.store = store;
        this.address = address;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
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

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
