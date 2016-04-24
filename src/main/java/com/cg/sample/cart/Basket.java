package com.cg.sample.cart;

import java.math.BigDecimal;
import java.util.Map;

public interface Basket {

    boolean addToBasket(final String itemName);

    Map<Item, Integer> getItems();

    BigDecimal getTotal();

    BigDecimal getTotalAfterDiscount();
}
