package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class CartManager {

	
	private Map<Integer, Cart> cartItems;

    public CartManager() {
        cartItems = new HashMap<>();
    }

    // Add item or update quantity if already present
    public void addCartItem(Cart cartItem) {
        int itemId = cartItem.getItemId();
        if (cartItems.containsKey(itemId)) {
            Cart existingItem = cartItems.get(itemId);
            existingItem.setQuantity(existingItem.getQuantity() + cartItem.getQuantity());
        } else {
            cartItems.put(itemId, cartItem);
        }
    }

    // Update quantity
    public void updateCartItemQuantity(int itemId, int quantity) {
        if (cartItems.containsKey(itemId)) {
            cartItems.get(itemId).setQuantity(quantity);
        }
    }

    // Remove item
    public void removeCartItem(int itemId) {
        cartItems.remove(itemId);
    }

    // Get all items
    public Map<Integer, Cart> getCartItems() {
        return cartItems;
    }
    
    
    public double calculateTotal() {
        double total = 0.0;
        for (Cart item : cartItems.values()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }


    // Clear cart
    public void clearCart() {
        cartItems.clear();
    }
	
	
}
