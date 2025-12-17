package com.ecommerce.EcommerceProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.EcommerceProject.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
