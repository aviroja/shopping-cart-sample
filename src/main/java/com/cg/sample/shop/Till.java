package com.cg.sample.shop;

import com.cg.sample.cart.Basket;
import com.cg.sample.cart.GroceryBasket;

import java.util.Scanner;

public class Till {

    private static final String EXIT = "exit";

    public static void main(String[] args) {
        Till till = new Till();
        till.checkout();
    }

    private void checkout() {
        Basket basket = new GroceryBasket();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please start scanning items by entering name. " +
                                   "Enter '" + EXIT + "' to finish.");
        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase(EXIT)) {
                break;
            }
            if (!basket.addToBasket(input)) {
                System.out.println("we don't sell [ " + input + " ] in our store");
            }
        }

        System.out.println(basket.getItems() + " ==> " + basket.getTotal());
    }
}
