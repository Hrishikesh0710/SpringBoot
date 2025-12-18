package com.tyss.__SB_LayersInSb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.__SB_LayersInSb.dto.FilterDTO;
import com.tyss.__SB_LayersInSb.model.Product;
import com.tyss.__SB_LayersInSb.service.ProductService;

@RestController
@RequestMapping("/ps")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/fetch")
    public List<Product> fetchAll() {
        return productService.findAll();
    }

    @GetMapping("/fid/{pid}")
    public Product fetchById(@PathVariable Integer pid) {
        return productService.getById(pid);
    }

    @PutMapping("/update/{pid}")
    public Product updateProduct( @PathVariable Integer pid, @RequestBody Product product) {
        return productService.updateProduct(pid, product);
    }
    
    @DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		return productService.deleteById(id);
	}
    
    @GetMapping("/page")
	public List<Product> fetchByPage(@RequestParam Integer pageNumber) {
		List<Product> products = productService.fetchByPage(pageNumber);
		return products;
	}
   
 	@GetMapping("/sort")
 	public List<Product> sortRecords(@RequestParam(required = false, defaultValue = "price") String param,
 			@RequestParam(required = false) String order) {
 		return productService.sortProducts(param, order);
 	}

	@GetMapping("/filter")
	public List<Product> filterProducts(@RequestBody FilterDTO filterDTO) {
		List<Product> products = productService.filter(filterDTO);
		return products;
	}
 
	@GetMapping("/range")
	public List<Product> productByPriceRange(@RequestParam Double fPrice, @RequestParam Double tPrice) {
		return productService.priceRange(fPrice, tPrice);
	}

	@GetMapping("/search")
	public List<Product> searchByName(@RequestParam String name) {
		return productService.searchByName(name);
    
    
    
    
    
	}
    
    
}
