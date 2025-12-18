package com.ecommerce.EcommerceProject.service;

import com.ecommerce.EcommerceProject.entity.Order;

public interface PaymentService {
    Order pay(Long orderId, String method);
}
