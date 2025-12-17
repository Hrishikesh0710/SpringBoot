package com.ecommerce.EcommerceProject.service;

import com.ecommerce.EcommerceProject.entity.Order;

public interface OrderService {
    Order checkout(Long cartId);
 
}

