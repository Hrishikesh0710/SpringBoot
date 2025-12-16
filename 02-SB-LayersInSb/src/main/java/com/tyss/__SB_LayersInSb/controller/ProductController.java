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

import org.springframework.web.bind.annotation.RestController;

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
    
    
    
    
    
    
    
    
}
