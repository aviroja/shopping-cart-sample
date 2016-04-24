package com.cg.sample.cart;

import java.math.BigDecimal;
import java.util.List;

public interface Basket {

    boolean addToBasket(final String itemName);

    List<Item> getItems();

    BigDecimal getTotal();
}
