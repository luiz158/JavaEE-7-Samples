/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.psvideo.sessions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import org.javaee7.psvideo.entities.Item;

/**
 *
 * @author Masudul Haque
 */
@Stateful
@StatefulTimeout(value = 20, unit = TimeUnit.SECONDS)
public class ShoppingCartEJB {

    private List<Item> cartItems = new ArrayList<>();

    public void addItem(Item item) {
        if (!cartItems.contains(item)) {
            cartItems.add(item);
        }
    }

    public void removeItem(Item item) {
        if (cartItems.contains(item)) {
            cartItems.remove(item);
        }
    }

    public Integer getNumberOfItems() {
        if (cartItems == null || cartItems.isEmpty()) {
            return 0;
        }
        return cartItems.size();
    }

    public Float getTotal() {
        if (cartItems == null || cartItems.isEmpty()) {
            return 0f;
        }
        Float total = 0f;
        for (Item cartItem : cartItems) {
            total += (cartItem.getPrice());
        }
        return total;
    }

    public void empty() {
        cartItems.clear();
    }

    @Remove
    public void checkout() {
// Do some business logic
        cartItems.clear();
    }
}
