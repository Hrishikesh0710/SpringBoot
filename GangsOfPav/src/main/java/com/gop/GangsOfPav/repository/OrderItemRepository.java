package com.gop.GangsOfPav.repository;

import com.gop.GangsOfPav.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
