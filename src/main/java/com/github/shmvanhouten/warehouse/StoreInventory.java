package com.github.shmvanhouten.warehouse;

import java.time.LocalDate;
import java.util.*;

public class StoreInventory {

    private Map<Product,Integer> products = new HashMap<>();

    public Integer getQuantityOfProducts() {
        Integer totalQuatityOfProducts = 0;
        for (Product product:products.keySet()) {
            Integer q = products.get(product);
            totalQuatityOfProducts += q;
        }
        return totalQuatityOfProducts;
    }

    public void addProduct (String productName, LocalDate expirationDate,Integer quantityOfProduct) {
        Product product = new Product (productName,expirationDate);
        if (products.containsKey(product)){
            Integer q = products.get(product);
            Integer newQuantity = q + quantityOfProduct;
            products.put (product,newQuantity);
        } else {
            products.put(product, quantityOfProduct);
        }
    }

    public Integer getQuantityOfProduct(String productName) {
        Integer totalQuantityOfProduct = 0;
        for (Product product:products.keySet()) {
            String name = product.getProductName();
            if (name.equals(productName)) {
                Integer q = products.get(product);
                totalQuantityOfProduct += q;
            }
        }
        return totalQuantityOfProduct;
    }

    public Integer getQuantityOfProductWithASpecificExpirationDate(String productName, LocalDate expirationDate) {
        Product product = new Product(productName, expirationDate);
        return products.get(product);
    }

    public List<Product> getProductsSortedByName() {

        return getProducts(new ProductByProductNameComparator());
    }

    public List<Product> getProductsSortedByExpirationDate() {

        return getProducts(new ProductByExpirationDateComparator());

    }
    private List<Product> getProducts(Comparator<Product> c) {
        List<Product> sortedList = new ArrayList<>();
        sortedList.addAll(products.keySet());
        Collections.sort(sortedList, c);
        return sortedList;
    }

}
