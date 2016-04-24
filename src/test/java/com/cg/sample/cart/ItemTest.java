package com.cg.sample.cart;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

public class ItemTest {
    @Test
    public void shouldReturnItem() {
        Item orange = Item.get("Orange");
        assertThat(orange, is(notNullValue()));
        assertThat(orange.getName(), is(equalTo(Item.ORANGE.getName())));
        assertThat(orange.getPrice(), is(equalTo(Item.ORANGE.getPrice())));
        assertThat(orange.toString(), is(equalTo(Item.ORANGE.getName())));

        Item apple = Item.get("apple");
        assertThat(apple, is(notNullValue()));
        assertThat(apple.getName(), is(equalTo(Item.APPLE.getName())));
        assertThat(apple.getPrice(), is(equalTo(Item.APPLE.getPrice())));
        assertThat(apple.toString(), is(equalTo(Item.APPLE.getName())));
    }

    @Test
    public void shouldReturnNullForInvalidItem() {
        Item grapes = Item.get("Grapes");
        assertThat(grapes, is(nullValue()));
    }
}
