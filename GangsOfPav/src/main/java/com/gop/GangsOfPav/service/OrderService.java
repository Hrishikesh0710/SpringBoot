package com.gop.GangsOfPav.service;

import com.gop.GangsOfPav.entity.Order;
import com.gop.GangsOfPav.entity.OrderItem;
import com.gop.GangsOfPav.entity.User;
import com.gop.GangsOfPav.enums.OrderStatus;
import com.gop.GangsOfPav.exception.ResourceNotFoundException;
import com.gop.GangsOfPav.repository.OrderRepository;
import com.gop.GangsOfPav.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(
            OrderRepository orderRepository,
            UserRepository userRepository
    ) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    // ✅ PLACE ORDER
    public Order placeOrder(String email, List<OrderItem> items, Double totalAmount) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found: " + email));

        Order order = new Order();
        order.setUser(user);
        order.setTotalAmount(totalAmount);
        order.setStatus(OrderStatus.PLACED);

        items.forEach(item -> item.setOrder(order));
        order.setItems(items);

        return orderRepository.save(order);
    }

    // ✅ GET USER ORDERS
    public List<Order> getOrdersByUser(String email) {
        return orderRepository.findByUser_Email(email);
    }

    // ✅ UPDATE ORDER STATUS (future admin use)
    public Order updateOrderStatus(Long orderId, OrderStatus status) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found: " + orderId));

        order.setStatus(status);
        return orderRepository.save(order);
    }
}
