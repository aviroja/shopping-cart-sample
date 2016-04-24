package com.cg.sample.cart;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class GroceryBasketTest {
    private Basket underTest = new GroceryBasket();

    @Test
    public void shouldAddOrangeToTheBasket() {
        boolean success = underTest.addToBasket("Orange");
        assertThat(success, is(equalTo(true)));
        assertThat(underTest.getItems().size(), is(equalTo(1)));
        assertThat(underTest.getItems(), contains(hasProperty("name", is(Item.ORANGE.getName()))));
        assertThat(underTest.getTotal(), is(equalTo(new BigDecimal(0.25).setScale(2, BigDecimal.ROUND_HALF_UP))));
    }

    @Test
    public void shouldAddAppleToTheBasket() {
        boolean success = underTest.addToBasket("Apple");
        assertThat(success, is(equalTo(true)));
        assertThat(underTest.getItems().size(), is(equalTo(1)));
        assertThat(underTest.getItems(), contains(hasProperty("name", is(Item.APPLE.getName()))));
        assertThat(underTest.getTotal(), is(equalTo(new BigDecimal(0.60).setScale(2, BigDecimal.ROUND_HALF_UP))));
    }

    @Test
    public void shouldNotAddToTheBasket() {
        boolean success = underTest.addToBasket("Grapes");
        assertThat(success, is(equalTo(false)));
        assertThat(underTest.getItems().size(), is(equalTo(0)));
        assertThat(underTest.getTotal(), is(equalTo(new BigDecimal(0.0).setScale(2, BigDecimal.ROUND_HALF_UP))));
    }

    @Test
    public void shouldAddMultipleItemsToTheBasket() {
        underTest.addToBasket("Orange");
        underTest.addToBasket("Orange");
        underTest.addToBasket("Grapes");
        underTest.addToBasket("Apple");
        underTest.addToBasket("apple");
        underTest.addToBasket("orange");
        underTest.addToBasket("Apple");
        underTest.addToBasket("Apple");

        assertThat(underTest.getItems().size(), is(equalTo(7)));
        assertThat(underTest.getItems(), contains(hasProperty("name", is(Item.ORANGE.getName())),
                hasProperty("name", is(Item.ORANGE.getName())),
                hasProperty("name", is(Item.APPLE.getName())),
                hasProperty("name", is(Item.APPLE.getName())),
                hasProperty("name", is(Item.ORANGE.getName())),
                hasProperty("name", is(Item.APPLE.getName())),
                hasProperty("name", is(Item.APPLE.getName()))));
        assertThat(underTest.getTotal(), is(equalTo(new BigDecimal(3.15).setScale(2, BigDecimal.ROUND_HALF_UP))));
    }
}
