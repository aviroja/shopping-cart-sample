package com.cg.sample.cart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class GroceryBasket implements Basket {
    private Map<Item, Integer> items = new HashMap<>();
    private BigDecimal total = new BigDecimal(0.0);
    private BigDecimal totalAfterDiscount = new BigDecimal(0.0);

    @Override
    public boolean addToBasket(final String itemName) {
        Item item = Item.get(itemName);
        if (item != null) {
            if (items.containsKey(item)) {
                items.put(item, (items.get(item) + 1));
            } else {
                items.put(item, 1);
            }
            total = total.add(item.getPrice());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Map<Item, Integer> getItems() {
        return items;
    }

    @Override
    public BigDecimal getTotal() {
        return total.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public BigDecimal getTotalAfterDiscount() {
        DiscountCalculator calculator = new DiscountCalculator();
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            totalAfterDiscount = totalAfterDiscount.add(calculator.calculatePrice(entry.getKey(), entry.getValue()));
        }
        return totalAfterDiscount.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
