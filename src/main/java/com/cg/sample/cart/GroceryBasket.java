package com.cg.sample.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GroceryBasket implements Basket {
    private List<Item> items = new ArrayList<>();
    private BigDecimal total = new BigDecimal(0.0);

    @Override
    public boolean addToBasket(final String itemName) {
        Item item = Item.get(itemName);
        if (item != null) {
            this.items.add(item);
            this.total = this.total.add(item.getPrice());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Item> getItems() {
        return this.items;
    }

    @Override
    public BigDecimal getTotal() {
        return this.total.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
