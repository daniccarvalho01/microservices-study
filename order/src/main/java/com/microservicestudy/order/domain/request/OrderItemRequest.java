package com.microservicestudy.order.domain.request;

public class OrderItemRequest {

    private Integer product;
    private Integer quantity;
    private Double price;

    public OrderItemRequest() {
    }

    public OrderItemRequest(Integer product, Integer quantity, Double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
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
