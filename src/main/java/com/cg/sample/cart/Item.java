package com.cg.sample.cart;

import java.math.BigDecimal;

public enum Item {

    APPLE("Apple", new BigDecimal(0.60)),
    ORANGE("Orange", new BigDecimal(0.25));

    private final String name;
    private final BigDecimal price;

    Item(final String name, final BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public static Item get(final String name) {
        for (Item item : values()) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
