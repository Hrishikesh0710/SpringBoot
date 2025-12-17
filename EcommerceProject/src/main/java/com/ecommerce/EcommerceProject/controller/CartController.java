package com.ecommerce.EcommerceProject.controller;

import org.springframework.web.bind.annotation.*;

import com.ecommerce.EcommerceProject.entity.Cart;
import com.ecommerce.EcommerceProject.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping
    public Cart createCart() {
        return service.createCart();
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable Long id) {
        return service.getCart(id);
    }

    @PostMapping("/{cartId}/add/{productId}")
    public Cart addProduct(@PathVariable Long cartId,
                           @PathVariable Long productId,
                           @RequestParam int quantity) {
        return service.addProduct(cartId, productId, quantity);
    }
}
