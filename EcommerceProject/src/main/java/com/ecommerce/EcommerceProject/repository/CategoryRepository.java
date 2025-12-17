package com.ecommerce.EcommerceProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.EcommerceProject.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
