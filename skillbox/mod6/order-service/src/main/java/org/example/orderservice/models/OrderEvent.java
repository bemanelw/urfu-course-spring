package org.example.orderservice.models;


public class OrderEvent {
    private String product;
    private Integer quantity;

    // getters and setters
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
