package com.storemanagement.controller;

import com.storemanagement.dto.request.CartItemRequest;
import com.storemanagement.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public String addToCart(@RequestBody CartItemRequest request){
        cartService.addToCart(request);
        return "Item added to cart";
    }

    @GetMapping
    public List<CartItemRequest> getcart(){
        return cartService.getCartItems();
    }

    @DeleteMapping
    public String clearCart(){
        cartService.clearCart();
        return "Cart cleared";
    }
}
