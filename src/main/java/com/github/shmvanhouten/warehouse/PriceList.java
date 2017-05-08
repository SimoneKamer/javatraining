package com.github.shmvanhouten.warehouse;

import java.util.HashMap;
import java.util.Map;

public class PriceList {

    private Map<String,ProductPrice> prices = new HashMap<>();
    public void addPriceForProduct (String productName, Integer productPrice) {
        ProductPrice price = new ProductPrice (productName,productPrice);
        if (isProductInPriceList(productName)){
            produceWarning(productName, productPrice);
        }
        prices.put(productName,price);
    }

    private void produceWarning(String productName, Integer productPrice) {
        ProductPrice p = prices.get(productName);
        System.out.println("Old price of " + (p.getProductPrice()/100) + " changed into new price of " + (productPrice/100));
    }

    private boolean isProductInPriceList(String productName) {
        return prices.containsKey(productName);
    }

    public Integer getProductPrice(String productName) {
        ProductPrice selectedProduct = prices.get(productName);
        return selectedProduct.getProductPrice();
    }

}
