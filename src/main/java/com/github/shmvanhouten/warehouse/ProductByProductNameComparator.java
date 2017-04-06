package com.github.shmvanhouten.warehouse;

import java.util.Comparator;

public class ProductByProductNameComparator implements Comparator<Product> {

    @Override
    public int compare(Product first, Product second) {
        int byProductName = first.getProductName().compareTo(second.getProductName());
        if (byProductName != 0) {
            return byProductName;
        }
        return first.getExpirationDate().compareTo(second.getExpirationDate());
    }
}
