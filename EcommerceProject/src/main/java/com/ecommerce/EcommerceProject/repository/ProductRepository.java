package com.ecommerce.EcommerceProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.EcommerceProject.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
