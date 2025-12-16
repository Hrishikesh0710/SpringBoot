package com.tyss.__SB_LayersInSb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyss.__SB_LayersInSb.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
