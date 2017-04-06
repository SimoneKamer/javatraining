package com.github.shmvanhouten.warehouse;

import java.util.Comparator;

public class ProductByExpirationDateComparator implements Comparator<Product> {

    @Override
    public int compare(Product first, Product second) {
        int byExpirationDate = first.getExpirationDate().compareTo(second.getExpirationDate());
        if (byExpirationDate != 0) {
            return byExpirationDate;
        }
        return first.getProductName().compareTo(second.getProductName());
    }
}
