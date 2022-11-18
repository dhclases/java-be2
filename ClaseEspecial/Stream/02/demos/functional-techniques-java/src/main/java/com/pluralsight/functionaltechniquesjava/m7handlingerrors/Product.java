package com.pluralsight.functionaltechniquesjava.m7handlingerrors;

public class Product {
    private Long productId;

    public Product() {}

    public Product(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
