package com.ecommerce.EcommerceProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.EcommerceProject.entity.Order;
import com.ecommerce.EcommerceProject.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/pay/{orderId}")
    public Order makePayment(
            @PathVariable Long orderId,
            @RequestParam String method) {

        return paymentService.pay(orderId, method);
    }
}
