package com.cg.sample.cart;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class DiscountCalculatorTest {

    DiscountCalculator underTest = new DiscountCalculator();

    @Test
    public void shouldCalculateApplePriceAfterDiscount() {
        assertThat(underTest.calculateApplePrice(Item.APPLE, 1), is(equalTo(new BigDecimal(0.60)
                                                                                    .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculateApplePrice(Item.APPLE, 2), is(equalTo(new BigDecimal(0.60)
                                                                                    .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculateApplePrice(Item.APPLE, 3), is(equalTo(new BigDecimal(1.20)
                                                                                    .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculateApplePrice(Item.APPLE, 4), is(equalTo(new BigDecimal(1.20)
                                                                                    .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculateApplePrice(Item.APPLE, 5), is(equalTo(new BigDecimal(1.80)
                                                                                    .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculateApplePrice(Item.APPLE, 6), is(equalTo(new BigDecimal(1.80)
                                                                                    .setScale(2, BigDecimal.ROUND_HALF_UP))));
    }

    @Test
    public void shouldCalculateOrangePriceAfterDiscount() {
        assertThat(underTest.calculateOrangePrice(Item.ORANGE, 1), is(equalTo(new BigDecimal(0.25)
                                                                                      .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculateOrangePrice(Item.ORANGE, 2), is(equalTo(new BigDecimal(0.50)
                                                                                      .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculateOrangePrice(Item.ORANGE, 3), is(equalTo(new BigDecimal(0.50)
                                                                                      .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculateOrangePrice(Item.ORANGE, 4), is(equalTo(new BigDecimal(0.75)
                                                                                      .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculateOrangePrice(Item.ORANGE, 5), is(equalTo(new BigDecimal(1.00)
                                                                                      .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculateOrangePrice(Item.ORANGE, 6), is(equalTo(new BigDecimal(1.00)
                                                                                      .setScale(2, BigDecimal.ROUND_HALF_UP))));
    }

    @Test
    public void shouldCalculatePriceAfterDiscount() {
        assertThat(underTest.calculatePrice(Item.APPLE, 1), is(equalTo(new BigDecimal(0.60)
                                                                               .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculatePrice(Item.APPLE, 2), is(equalTo(new BigDecimal(0.60)
                                                                               .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculatePrice(Item.APPLE, 3), is(equalTo(new BigDecimal(1.20)
                                                                               .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculatePrice(Item.APPLE, 4), is(equalTo(new BigDecimal(1.20)
                                                                               .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculatePrice(Item.APPLE, 5), is(equalTo(new BigDecimal(1.80)
                                                                               .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculatePrice(Item.APPLE, 6), is(equalTo(new BigDecimal(1.80)
                                                                               .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculatePrice(Item.ORANGE, 1), is(equalTo(new BigDecimal(0.25)
                                                                                .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculatePrice(Item.ORANGE, 2), is(equalTo(new BigDecimal(0.50)
                                                                                .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculatePrice(Item.ORANGE, 3), is(equalTo(new BigDecimal(0.50)
                                                                                .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculatePrice(Item.ORANGE, 4), is(equalTo(new BigDecimal(0.75)
                                                                                .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculatePrice(Item.ORANGE, 5), is(equalTo(new BigDecimal(1.00)
                                                                                .setScale(2, BigDecimal.ROUND_HALF_UP))));

        assertThat(underTest.calculatePrice(Item.ORANGE, 6), is(equalTo(new BigDecimal(1.00)
                                                                                .setScale(2, BigDecimal.ROUND_HALF_UP))));
    }
}
