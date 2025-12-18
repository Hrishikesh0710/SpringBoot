package com.ecommerce.EcommerceProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.EcommerceProject.entity.Order;
import com.ecommerce.EcommerceProject.repository.OrderRepository;
import com.ecommerce.EcommerceProject.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order pay(Long orderId, String method) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Dummy payment logic
        if (method.equalsIgnoreCase("UPI")
                || method.equalsIgnoreCase("CARD")
                || method.equalsIgnoreCase("COD")) {

            order.setStatus("PAID");
        } else {
            throw new RuntimeException("Invalid payment method");
        }

        return orderRepository.save(order);
    }
}
