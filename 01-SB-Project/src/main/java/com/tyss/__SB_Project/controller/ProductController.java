package com.tyss.__SB_Project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.__SB_Project.model.Product;
import com.tyss.__SB_Project.repository.ProductRepository;

@RestController
@RequestMapping("/pd")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		Product saved = productRepository.save(product);    
		return saved;
	}
	
	@GetMapping
	public Iterable<Product> fetchAll() {
		Iterable<Product> all = productRepository.findAll();
		return all;
	}
	
	@GetMapping("/FetchById")
	public Product fetchById(@RequestParam Integer pid) {
		Optional<Product> opt = productRepository.findById(pid);

		if (opt.isPresent()) {
			Product product = opt.get();
			return product;
		} else {
			System.out.println("not found");
			return null;
		}

		//Product product = opt.orElseThrow(() -> new RuntimeException("Product not found"));
		//return product;
		
		//return productRepository.findById(pid).orElseThrow(() -> new RuntimeException("Product not found"));
	}
	
	@DeleteMapping("/{pid}")
	public String delete(@PathVariable Integer pid) {
	    productRepository.deleteById(pid);
	    return "Deleted successfully";
	}


	
}
