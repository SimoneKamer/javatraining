package com.github.shmvanhouten.warehouse;

import java.time.LocalDate;

public class Product {

    private final String productName;
    private final LocalDate expirationDate;

    public Product(String productName, LocalDate expirationDate) {
        this.productName = productName;
        this.expirationDate = expirationDate;
    }

        @Override
        public boolean equals(Object obj){

            System.out.println("Equals called to compare " + this + " with " + obj);

            if (obj instanceof Product) {
                Product other = (Product) obj;
                if (this.productName.equals(other.getProductName())
                        && this.expirationDate.equals(other.getExpirationDate())) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            System.out.println("hashCode calculated for " + this);
            return this.productName.charAt(0);
        }

        @Override
        public String toString () {
            return "Product{" +
                    "productName='" + productName + '\'' +
                    ", expirationDate=" + expirationDate +
                    '}';
        }
//        @Override
//        public int compareTo(Product other) {
//            return this.expirationDate.compareTo(other.getExpirationDate());
//        }

    public String getProductName() {
            return productName;
    }

    public LocalDate getExpirationDate() {
            return expirationDate;
    }
}