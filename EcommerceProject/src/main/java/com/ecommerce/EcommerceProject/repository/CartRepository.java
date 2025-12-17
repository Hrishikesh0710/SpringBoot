package com.ecommerce.EcommerceProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.EcommerceProject.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
