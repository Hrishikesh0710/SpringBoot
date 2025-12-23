package com.gop.GangsOfPav.repository;

import com.gop.GangsOfPav.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser_Email(String email);
}
