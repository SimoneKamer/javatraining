package com.github.shmvanhouten.warehouse;

public class ProductPrice {
    private final String productName;

    private final Integer productPrice;

    public ProductPrice(String productName, Integer productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }
}
