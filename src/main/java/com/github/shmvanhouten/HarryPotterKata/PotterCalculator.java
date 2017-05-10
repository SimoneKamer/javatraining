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
        List<Integer> sortedBasket = new ArrayList<>();
        sortedBasket = sortBasket(basket); // list met aantallen unieke boeken, gesorteerd in afnemend aantal
        if (basket.size() % 5 == 3) {
            totalPrice = calculatePriceWithCheaperMethod(totalPrice, basket);
        } else {
            totalPrice = calculatePriceTheStraightforwardWay(totalPrice, basket);
        }
        return totalPrice;
    }

    private List<Integer> sortBasket(List<String> basket) {
        List<Integer> sortedBasket = new ArrayList<>();
        int bookOne = 0;
        int bookTwo = 0;
        int bookThree = 0;
        int bookFour = 0;
        int bookFive = 0;
        for (String book : basket) {
            if (book == "one") {bookOne ++;}
            if (book == "two") {bookTwo ++;}
            if (book == "three") {bookThree ++;}
            if (book == "four") {bookFour ++;}
            if (book == "five") {bookFive ++;}
        }
        sortedBasket.add(bookOne);
        sortedBasket.add(bookTwo);
        sortedBasket.add(bookThree);
        sortedBasket.add(bookFour);
        sortedBasket.add(bookFive);
        Collections.sort(sortedBasket, Collections.reverseOrder());
        return sortedBasket;
    }

    public double calculatePriceWithCheaperMethod(double totalPrice, List<String> basket) {
        // TODO omkatten naar berekeningen maken met sortedBasket.
            while (!basket.isEmpty()){
            while (basket.size() > 8){
                totalPrice += 30;
                removeCompleteSubsetOfBooks(basket);
            }
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

    public void removeCompleteSubsetOfBooks(List<String> basket) {
        basket.remove("one");
        basket.remove("two");
        basket.remove("three");
        basket.remove("four");
        basket.remove("five");
    }

    public double calculatePriceTheStraightforwardWay(double totalPrice, List<String> basket) {
        // TODO omkatten naar berekeningen maken met sortedBasket.
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