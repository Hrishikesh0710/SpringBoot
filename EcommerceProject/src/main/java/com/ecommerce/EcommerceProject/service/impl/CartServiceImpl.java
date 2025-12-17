package com.ecommerce.EcommerceProject.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ecommerce.EcommerceProject.entity.Cart;
import com.ecommerce.EcommerceProject.entity.CartItem;
import com.ecommerce.EcommerceProject.entity.Product;
import com.ecommerce.EcommerceProject.repository.CartItemRepository;
import com.ecommerce.EcommerceProject.repository.CartRepository;
import com.ecommerce.EcommerceProject.repository.ProductRepository;
import com.ecommerce.EcommerceProject.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepo;
    private final CartItemRepository cartItemRepo;
    private final ProductRepository productRepo;

    public CartServiceImpl(CartRepository cartRepo,
                           CartItemRepository cartItemRepo,
                           ProductRepository productRepo) {
        this.cartRepo = cartRepo;
        this.cartItemRepo = cartItemRepo;
        this.productRepo = productRepo;
    }

    @Override
    public Cart createCart() {
        Cart cart = new Cart();
        cart.setItems(new ArrayList<>());
        return cartRepo.save(cart);
    }

    @Override
    public Cart getCart(Long cartId) {
        return cartRepo.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    @Override
    public Cart addProduct(Long cartId, Long productId, int quantity) {
        Cart cart = getCart(cartId);
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(quantity);

        cartItemRepo.save(item);
        cart.getItems().add(item);

        return cartRepo.save(cart);
    }
}
