package com.github.shmvanhouten.warehouse;

import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static java.time.LocalDate.of;
import static java.time.Month.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class ProductTest {
    @Test
    public void itShouldHaveNameAndExpirationDateOfProduct() throws Exception {

        Product product = new Product("tomatenpuree", of(2017, MAY, 19));

        assertThat(product.getProductName(), is("tomatenpuree"));
        assertThat(product.getExpirationDate().getYear(), is(2017));
    }

    @Ignore
    @Test
    public void itShouldHaveMoreThanOneProduct() throws Exception {

        Product puree = new Product("tomatenpuree", of(2017, MAY, 19));
        Product soep = new Product("tomatensoep", of(2018, JUNE, 14));
        Product saus = new Product("roomsaus", of(2017, JANUARY, 1));
        Product groente = new Product("bloemkool", of(2017, MAY, 19));

        List<Product> products = new ArrayList<>();
        products.add(puree);
        products.add(soep);
        products.add(saus);
        products.add(groente);

        Integer amountOfProducts = products.size();
        assertThat(amountOfProducts, is (4));

        printProducts(products);
    }

    @Ignore
    @Test
    public void inShouldNoticeThatProductsAreTheSame() throws Exception {
        Product puree = new Product("tomatenpuree", of(2017, MAY, 19));
        Product soep = new Product("tomatensoep", of(2018, JUNE, 14));
        Product saus = new Product("roomsaus", of(2017, JANUARY, 1));
        Product saus2 = new Product("roomsaus", of(2017, JANUARY, 1));
        Product groente = new Product("bloemkool", of(2017, MAY, 19));

        assertThat(saus, is (saus2));
    }

    private void printProducts(Collection<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}