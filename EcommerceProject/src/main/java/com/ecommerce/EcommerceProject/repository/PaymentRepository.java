package com.ecommerce.EcommerceProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.EcommerceProject.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
