package com.github.shmvanhouten.warehouse;

    import org.junit.Test;

    import java.time.LocalDate;
    import java.util.List;

    import static java.time.LocalDate.of;
    import static java.time.Month.APRIL;
    import static java.time.Month.JUNE;
    import static java.time.Month.MAY;
    import static org.hamcrest.MatcherAssert.assertThat;
    import static org.hamcrest.Matchers.is;

public class StoreInventoryTest {
    @Test
    public void itShouldHaveAnEmptyStore() throws Exception {
        StoreInventory i = new StoreInventory();
        assertThat(i.getQuantityOfProducts(), is(0));
    }

    @Test
    public void itShouldBeAbleToAddProducts() throws Exception {
        StoreInventory i = new StoreInventory();
        i.addProduct("tomatenpuree", of(2017, MAY, 19), 15);
        assertThat(i.getQuantityOfProducts(), is(15));
    }

    @Test
    public void itShouldBeAbleToAddMoreDifferentProducts() throws Exception {
        StoreInventory i = new StoreInventory();
        i.addProduct("tomatenpuree", of(2017, MAY, 19), 15);
        i.addProduct("tomatensaus", of(2017, MAY, 19), 15);
        assertThat(i.getQuantityOfProducts(), is(30));
    }

    @Test
    public void itShouldBeAbleToAddMoreOfTheSameProducts() throws Exception {
        StoreInventory i = new StoreInventory();
        i.addProduct("tomatenpuree", of(2017, MAY, 19), 15);
        i.addProduct("tomatenpuree", of(2017, MAY, 19), 2);
        assertThat(i.getQuantityOfProducts(), is(17));
    }

    @Test
    public void itShouldBeAbleToAddMoreProductsWithComparableParameters() throws Exception {
        StoreInventory i = new StoreInventory();
        i.addProduct("tomatenpuree", of(2017, MAY, 19), 15);
        i.addProduct("tomatenpuree", of(2017, MAY, 19), 2);
        i.addProduct("tomatensaus", of(2017, MAY, 19), 20);
        i.addProduct("tomatensaus", of(2017, MAY, 19), 5);
        i.addProduct("tomatenpuree", of(2018, MAY, 19), 3);
        i.addProduct("tomatensaus", of(2018, MAY, 19), 25);

        assertThat(i.getQuantityOfProducts(), is(70));
    }

    @Test
    public void itShouldBeAbleToTellTheAmountOfASpecificProduct() throws Exception {
        StoreInventory i = new StoreInventory();
        i.addProduct("tomatenpuree", of(2017, MAY, 19), 15);
        i.addProduct("tomatenpuree", of(2017, MAY, 19), 2);
        i.addProduct("tomatensaus", of(2017, MAY, 19), 20);
        i.addProduct("tomatensaus", of(2017, MAY, 19), 5);

        assertThat(i.getQuantityOfProduct("tomatenpuree"), is(17));
    }

    @Test
    public void ItShouldBeAbleToTellTheAmountOfASpecificProductWithASpecificExpirationDate() throws Exception {
        StoreInventory i = new StoreInventory();
        i.addProduct("tomatenpuree", of(2017, MAY, 19), 15);
        i.addProduct("tomatenpuree", of(2017, MAY, 19), 2);
        i.addProduct("tomatensaus", of(2017, MAY, 19), 20);
        i.addProduct("tomatenpuree", of(2018, MAY, 19), 5);

        assertThat(i.getQuantityOfProductWithASpecificExpirationDate("tomatenpuree", of(2017, MAY, 19)), is(17));

    }

    @Test
    public void ItShouldReturnASortedByProductNameList() throws Exception {
        LocalDate MAY_19_2018 = of(2018, MAY, 19);

        StoreInventory i = new StoreInventory();
        i.addProduct("tomatenpuree", of(2017, MAY, 19), 15);
        i.addProduct("tomatenpuree", MAY_19_2018, 20);
        i.addProduct("bloemkool", of(2018, MAY, 19), 5);

        List<Product> products = i.getProductsSortedByName();

        assertThat(products.get(0).getProductName(), is("bloemkool"));
        assertThat(products.get(1).getProductName(), is("tomatenpuree"));
        assertThat(products.get(2).getProductName(), is("tomatenpuree"));
        assertThat(products.get(2).getExpirationDate(), is(MAY_19_2018));
    }

    @Test
    public void itShouldReturnASortedByExpirationDateList() throws Exception {
        LocalDate MAY_19_2018 = of(2018, MAY, 19);
        LocalDate MAY_19_2017 = of(2017, MAY, 19);

        StoreInventory i = new StoreInventory();
        i.addProduct("tomatenpuree", MAY_19_2017, 15);
        i.addProduct("tomatenpuree", MAY_19_2018, 20);
        i.addProduct("bloemkool", MAY_19_2018, 5);

        List<Product> products = i.getProductsSortedByExpirationDate();

        assertThat(products.get(0).getProductName(), is("tomatenpuree"));
        assertThat(products.get(1).getProductName(), is("bloemkool"));
        assertThat(products.get(2).getProductName(), is("tomatenpuree"));
        assertThat(products.get(2).getExpirationDate(), is(MAY_19_2018));
    }

    @Test
    public void itShouldKnowAPriceForAProduct() throws Exception {
        PriceList p = new PriceList();
        p.addPriceForProduct("tomatenpuree", 9);
        assertThat(p.getProductPrice("tomatenpuree"), is(9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldRefuseAlreadyEpiredProducts() throws Exception {
        StoreInventory i = new StoreInventory();
        i.addProduct("tomatenpuree", of(2016, MAY, 19), 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldRefuseAlreadyExpiredProducts() throws Exception {
        StoreInventory inventory = new StoreInventory();
        inventory.addProduct("tomatoSoup", of(2016, JUNE, 29), 20);
    }

    @Test
    public void itShouldHandleAlreadyExpiredProducts() throws Exception {
        LocalDate MAY_19_2018 = of(2018, MAY, 19);
        LocalDate MAY_19_2017 = of(2017, MAY, 19);
        StoreInventory i = new StoreInventory();
        try {
            i.addProduct("tomatenpuree", of(2016, MAY, 19), 15);
            i.addProduct("tomatenpuree", MAY_19_2017, 15);
            i.addProduct("tomatenpuree", MAY_19_2018, 20);
            i.addProduct("bloemkool", MAY_19_2018, 5);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
        }
        assertThat(i.getQuantityOfProduct("tomatenpuree"), is (35));
        // fails because code is not executed after the exception in line 141
    }

    @Test
    public void itShouldHandleExpiredProducts() throws Exception {
        StoreInventory i = new StoreInventory();

        i.attemptToAddItemToInventory("tomatoSoup", of(2016, JUNE, 29), 20);
        i.attemptToAddItemToInventory("tomatoSoup", of(2017, JUNE, 30), 20);
        i.attemptToAddItemToInventory("tomatoSoup", of(2017, JUNE, 29), 15);
        i.attemptToAddItemToInventory("marsBars", of(2017, APRIL, 20), 80);

        List<Product> inventoryList = i.getInventoryList();
        System.out.println("Continue with " + inventoryList.size() + " items");
        assertThat(i.getQuantityOfProduct("tomatoSoup"), is (35));
        // resume normal program
    }
}