package com.storemanagement.service.impl;

import com.storemanagement.dto.request.CartItemRequest;
import com.storemanagement.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final List<CartItemRequest> cart = new ArrayList<>();

    @Override
    public void addToCart(CartItemRequest request) {
        cart.add(request);
    }

    @Override
    public List<CartItemRequest> getCartItems() {
        return cart;
    }

    @Override
    public void clearCart() {
        cart.clear();
    }
}
