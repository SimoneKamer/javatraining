package com.github.shmvanhouten.HarryPotterKata;

import java.util.*;

public class PotterCalculator{
    private final double bookPrice = 8;

    private Map<Integer,Double> discountPercentage = new HashMap<>();

    public PotterCalculator(){
        discountPercentage.put(1,1.00);
        discountPercentage.put(2,0.95);
        discountPercentage.put(3,0.90);
        discountPercentage.put(4,0.80);
        discountPercentage.put(5,0.75);
    }

    public double calculatePrice (String[] shoppingBasket) {
        double totalPrice = 0;
        List<String> basket = new ArrayList<>(Arrays.asList(shoppingBasket));
        if (basket.size() % 5 == 3) {
            totalPrice = calculatePriceWithCheaperMethod(totalPrice, basket);
        } else {
            totalPrice = calculatePriceTheStraightforwardWay(totalPrice, basket);
        }
        return totalPrice;
    }

    public double calculatePriceWithCheaperMethod(double totalPrice, List<String> basket) {
        while (!basket.isEmpty()){
            Set<String> subsetOfBooks = new HashSet<>();
            for (String book : basket) {
                if (!subsetOfBooks.contains(book) && subsetOfBooks.size()<4){
                    subsetOfBooks.add(book);
                }
            }
            double percentage = determineDiscountPercentage(subsetOfBooks);
            totalPrice += bookPrice*subsetOfBooks.size()*percentage;
            for (String book : subsetOfBooks){
                basket.remove(book);
            }
        }
        return totalPrice;
    }

    public double calculatePriceTheStraightforwardWay(double totalPrice, List<String> basket) {
        while (!basket.isEmpty()){
            Set<String> subsetOfBooks = new HashSet<>();
            for (String book : basket){
                if (!subsetOfBooks.contains(book)){
                    subsetOfBooks.add(book);
                }
            }
            double percentage = determineDiscountPercentage(subsetOfBooks);
            totalPrice += bookPrice*subsetOfBooks.size()*percentage;
            for (String book : subsetOfBooks){
                basket.remove(book);
            }
        }
        return totalPrice;
    }

    private double determineDiscountPercentage(Set<String> subsetOfBooks){
        return discountPercentage.get(subsetOfBooks.size());
    }

}