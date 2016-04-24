package com.cg.sample.cart;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class GroceryBasketTest {

    private Basket underTest = new GroceryBasket();

    @Test
    public void shouldAddToBasket() {
        boolean success = underTest.addToBasket("Orange");
        assertThat(success, is(equalTo(true)));
        assertThat(underTest.getItems().size(), is(equalTo(1)));
        assertThat(underTest.getItems().keySet(), contains(hasProperty("name", is(Item.ORANGE.getName()))));
        assertThat(underTest.getTotal(), is(equalTo(new BigDecimal(0.25).setScale(2, BigDecimal.ROUND_HALF_UP))));
        assertThat(underTest.getTotalAfterDiscount(), is(equalTo(new BigDecimal(0.25)
                                                                         .setScale(2, BigDecimal.ROUND_HALF_UP))));
    }

    @Test
    public void shouldNotAddToBasket() {
        boolean success = underTest.addToBasket("Grapes");
        assertThat(success, is(equalTo(false)));
        assertThat(underTest.getItems().size(), is(equalTo(0)));
        assertThat(underTest.getTotal(), is(equalTo(new BigDecimal(0.0).setScale(2, BigDecimal.ROUND_HALF_UP))));
        assertThat(underTest.getTotalAfterDiscount(), is(equalTo(new BigDecimal(0.0)
                                                                         .setScale(2, BigDecimal.ROUND_HALF_UP))));
    }

    @Test
    public void shouldAddMultipleItemsInTheBasket() {
        underTest.addToBasket("Orange");
        underTest.addToBasket("Orange");
        underTest.addToBasket("Grapes");
        underTest.addToBasket("Apple");
        underTest.addToBasket("apple");
        underTest.addToBasket("orange");
        underTest.addToBasket("Apple");
        underTest.addToBasket("Apple");

        assertThat(underTest.getItems().size(), is(equalTo(2)));
        assertThat(underTest.getItems().keySet(), containsInAnyOrder(hasProperty("name", is(Item.ORANGE.getName())),
                hasProperty("name", is(Item.APPLE.getName()))));
        assertThat(underTest.getItems().values(), containsInAnyOrder(3, 4));
        assertThat(underTest.getTotal(), is(equalTo(new BigDecimal(3.15).setScale(2, BigDecimal.ROUND_HALF_UP))));
        assertThat(underTest.getTotalAfterDiscount(), is(equalTo(new BigDecimal(1.70)
                                                                         .setScale(2, BigDecimal.ROUND_HALF_UP))));
    }
}
