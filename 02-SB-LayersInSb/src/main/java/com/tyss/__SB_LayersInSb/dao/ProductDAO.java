package com.tyss.__SB_LayersInSb.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.__SB_LayersInSb.model.Product;
import com.tyss.__SB_LayersInSb.repository.ProductRepository;

@Repository
public class ProductDAO {

	@Autowired
	private ProductRepository productRepository;
	

	public Product save(Product product) {

		return productRepository.save(product);
		
	}
	
	public Product getById(Integer pid) {
		return productRepository.findById(pid).orElseThrow(() -> new RuntimeException("Product Not Found"));
	}

	
	public void delete(Product product) {
		productRepository.delete(product);
	}


}
