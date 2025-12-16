package com.tyss.__SB_LayersInSb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.__SB_LayersInSb.dao.ProductDAO;
import com.tyss.__SB_LayersInSb.model.Product;
import com.tyss.__SB_LayersInSb.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ProductRepository productRepository;

	public Product save(Product product) {
		return productDAO.save(product);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product getById(Integer pid) {
		return productDAO.getById(pid);
	}
	
	public Product updateProduct(Integer pid, Product product) {
        return productDAO.update(pid, product);
    }

	public String deleteById(Integer id) {
		return productDAO.deleteById(id);
		
	}
}