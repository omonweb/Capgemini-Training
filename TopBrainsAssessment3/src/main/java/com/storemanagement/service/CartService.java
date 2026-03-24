package com.storemanagement.service;

import com.storemanagement.dto.request.CartItemRequest;

import java.util.List;

public interface CartService {

    void addToCart(CartItemRequest request);

    List<CartItemRequest> getCartItems();

    void clearCart();
}
