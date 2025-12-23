package com.gop.GangsOfPav.controller;

import com.gop.GangsOfPav.dto.OrderRequestDTO;
import com.gop.GangsOfPav.entity.Order;
import com.gop.GangsOfPav.entity.OrderItem;
import com.gop.GangsOfPav.enums.OrderStatus;
import com.gop.GangsOfPav.service.OrderService;
import com.gop.GangsOfPav.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final JwtUtil jwtUtil;

    public OrderController(OrderService orderService, JwtUtil jwtUtil) {
        this.orderService = orderService;
        this.jwtUtil = jwtUtil;
    }

    // ✅ PLACE ORDER
    @PostMapping
    public Order placeOrder(
            @Valid @RequestBody OrderRequestDTO request,
            HttpServletRequest httpRequest
    ) {
        String email = extractEmail(httpRequest);

        List<OrderItem> items = request.getItems()
                .stream()
                .map(dto -> new OrderItem(
                        dto.getItemName(),
                        dto.getPrice(),
                        dto.getQuantity()
                ))
                .toList();

        return orderService.placeOrder(
                email,
                items,
                request.getTotalAmount()
        );
    }

    // ✅ GET ORDERS FOR LOGGED-IN USER
    @GetMapping
    public List<Order> getOrders(HttpServletRequest request) {
        String email = extractEmail(request);
        return orderService.getOrdersByUser(email);
    }

    // 🔐 Extract email from JWT
    private String extractEmail(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");

        if (auth == null || !auth.startsWith("Bearer ")) {
            throw new RuntimeException("Missing Authorization header");
        }

        String token = auth.substring(7);
        return jwtUtil.extractUsername(token); // email
    }
}
