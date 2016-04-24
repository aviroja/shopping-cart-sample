package com.cg.sample.cart;

import java.math.BigDecimal;

public class DiscountCalculator {

    public BigDecimal calculatePrice(Item item, int quantity) {
        BigDecimal total = new BigDecimal(0.0);
        if (item == Item.APPLE) {
            total = total.add(calculateApplePrice(item, quantity));
        } else if (item == Item.ORANGE) {
            total = total.add(calculateOrangePrice(item, quantity));
        }
        return total;
    }

    BigDecimal calculateApplePrice(final Item item, int quantity) {
        BigDecimal price = item.getPrice().multiply(BigDecimal.valueOf(Math.round((double) quantity / 2)));
        return price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    BigDecimal calculateOrangePrice(final Item item, int quantity) {
        BigDecimal price = item.getPrice().multiply(BigDecimal.valueOf((quantity - (quantity / 3))));
        return price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
