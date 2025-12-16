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

	
	public Product update(Integer pid, Product product) {
		Product dbProd = getById(pid);

				if (product.getName() != null)
					dbProd.setName(product.getName());
				if (product.getPrice() != null)
					dbProd.setPrice(product.getPrice());
				if (product.getDescription() != null)
					dbProd.setDescription(product.getDescription());
				if (product.getColor() != null)
					dbProd.setColor(product.getColor());
		
				return save(dbProd);
	}

	public String deleteById(Integer pid) {
		productRepository.deleteById(pid);
		return "Deleted";
	}
	
	
	

}
