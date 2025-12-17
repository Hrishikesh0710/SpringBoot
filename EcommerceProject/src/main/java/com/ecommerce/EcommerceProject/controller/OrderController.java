package com.ecommerce.EcommerceProject.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.EcommerceProject.entity.Order;
import com.ecommerce.EcommerceProject.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/checkout/{cartId}")
    public Order checkout(@PathVariable Long cartId) {
        return orderService.checkout(cartId);
    }
    

    
}

