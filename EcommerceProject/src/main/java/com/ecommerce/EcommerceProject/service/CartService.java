package com.ecommerce.EcommerceProject.service;

import com.ecommerce.EcommerceProject.entity.Cart;

public interface CartService {
    Cart createCart();
    Cart getCart(Long cartId);
    Cart addProduct(Long cartId, Long productId, int quantity);
}
