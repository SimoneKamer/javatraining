package com.github.shmvanhouten.HarryPotterKata;

import org.junit.*;
import static org.junit.Assert.*;

public class PotterTest {

    @Test
    public void BuyOneBook() {
        PotterCalculator calculator = new PotterCalculator();
        String[] shoppingBasket = new String []{"one"};

        double actual = calculator.calculatePrice(shoppingBasket);

        assertEquals(8.00, actual, 0.01);
    }

    @Test
    public void BuyTwoSameBooks() {
        PotterCalculator calculator = new PotterCalculator();
        String[] shoppingBasket = new String []{"one", "one"};

        double actual = calculator.calculatePrice(shoppingBasket);

        assertEquals(16.00, actual, 0.01);
    }

    @Test
    public void BuyTwoDifferentBooks() {
        PotterCalculator calculator = new PotterCalculator();
        String[] shoppingBasket = new String []{"one", "two"};

        double actual = calculator.calculatePrice(shoppingBasket);

        assertEquals(15.20, actual, 0.01);
    }

    @Test
    public void BuyThreeDifferentBooks() {
        PotterCalculator calculator = new PotterCalculator();
        String[] shoppingBasket = new String []{"one", "two", "three"};

        double actual = calculator.calculatePrice(shoppingBasket);

        assertEquals(21.60, actual, 0.01);
    }

    @Test
    public void BuyASetOfTwoAndASetOfOneBook() {
        PotterCalculator calculator = new PotterCalculator();
        String[] shoppingBasket = new String []{"one", "two", "one"};

        double actual = calculator.calculatePrice(shoppingBasket);

        assertEquals(23.20, actual, 0.01);
    }

    @Test
    public void BuyASetOfFiveAndASetOfThreeBooks() {
        PotterCalculator calculator = new PotterCalculator();
        String[] shoppingBasket = new String []{"one", "two", "three",
                "one", "two", "three","four","five"};

        double actual = calculator.calculatePrice(shoppingBasket);

        assertEquals(51.20, actual, 0.01);
    }

    @Test
    public void BuyAMultipleOfFiveBooksPlusThreeBooks() {
        PotterCalculator calculator = new PotterCalculator();
        String[] shoppingBasket = new String []{"one", "two", "three",
                "one", "two", "three","four","five",
                "one", "two", "three","four","five"};

        double actual = calculator.calculatePrice(shoppingBasket);

        assertEquals(81.20, actual, 0.01);
    }

    @Test
    public void BuyEightSameBooks(){
        PotterCalculator calculator = new PotterCalculator();
        String[] shoppingBasket = new String []{
                "one", "one","one", "one","one", "one","one", "one"};
        double actual = calculator.calculatePrice(shoppingBasket);

        assertEquals(64, actual, 0.01);
    }
    @Test
    public void BuyAComplicatedSetOfFiveAndASetOfThreeBooks() {
        PotterCalculator calculator = new PotterCalculator();
        String[] shoppingBasket = new String []{
                "one", "one", "two", "three","three","four","five", "five"};

        double actual = calculator.calculatePrice(shoppingBasket);

        assertEquals(51.20, actual, 0.01);
    }
}