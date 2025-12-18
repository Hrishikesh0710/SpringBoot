package com.tyss.__SB_LayersInSb.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tyss.__SB_LayersInSb.dao.ProductDAO;
import com.tyss.__SB_LayersInSb.dto.FilterDTO;
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
		Product dbProd = productDAO.getById(pid);

		if (product.getName() != null)
			dbProd.setName(product.getName());
		if (product.getPrice() != null)
			dbProd.setPrice(product.getPrice());
		if (product.getDescription() != null)
			dbProd.setDescription(product.getDescription());
		if (product.getColor() != null)
			dbProd.setColor(product.getColor());

		return productDAO.save(dbProd);
    }

	public String deleteById(Integer id) {
				Product byId = productDAO.getById(id);
				productDAO.delete(byId);
				return "Deleted";
		
	}

	public List<Product> fetchByPage(Integer pageNumber) {
				Pageable pageable = PageRequest.of(pageNumber - 1, 10);
				Page<Product> all = productRepository.findAll(pageable);
				List<Product> products = all.toList();

		return products;
	}

	   public List<Product> sortProducts(String param, String order) {
			if (order != null && order.equalsIgnoreCase("desc")) {
				return productRepository.findAll(Sort.by(param).descending());
			}
			return productRepository.findAll(Sort.by(param).ascending());
		}

	   public List<Product> filter(FilterDTO filterDTO) {
		   Product product = new Product();

			BeanUtils.copyProperties(filterDTO, product);

			Example<Product> example = Example.of(product);

			List<Product> products = productRepository.findAll(example);

			return products;
	   }
	
	
	   public List<Product> priceRange(Double fPrice,Double tPrice) {
			return productRepository.getProductsPriceRange(fPrice, tPrice);
		}
		
		public List<Product> searchByName(String name) {
			return productRepository.findByNameContainingIgnoreCase(name);
		}

		public List<Product> searchByNameAndPrice(String name, Double price) {
			return productRepository.findByNameAndPrice(name, price);
		}
	
	
	
	
	
	
}