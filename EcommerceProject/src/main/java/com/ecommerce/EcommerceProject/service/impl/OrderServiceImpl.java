package com.ecommerce.EcommerceProject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.EcommerceProject.entity.Cart;
import com.ecommerce.EcommerceProject.entity.CartItem;
import com.ecommerce.EcommerceProject.entity.Order;
import com.ecommerce.EcommerceProject.entity.OrderItem;
import com.ecommerce.EcommerceProject.entity.Product;
import com.ecommerce.EcommerceProject.repository.CartRepository;
import com.ecommerce.EcommerceProject.repository.OrderRepository;
import com.ecommerce.EcommerceProject.repository.ProductRepository;
import com.ecommerce.EcommerceProject.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Order checkout(Long cartId) {

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Order order = new Order();
        order.setUserId(cartId); // simple mapping for now
        order.setStatus("CREATED");

        double total = 0;

        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem : cart.getItems()) {

            Product product = cartItem.getProduct();

            if (product.getStock() < cartItem.getQuantity()) {
                throw new RuntimeException("Insufficient stock");
            }


            product.setStock(product.getStock() - cartItem.getQuantity());
            productRepository.save(product);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(product.getPrice());

            total += product.getPrice() * cartItem.getQuantity();
            orderItems.add(orderItem);
        }

        order.setItems(orderItems);
        order.setTotalAmount(total);


        cart.getItems().clear();
        cartRepository.save(cart);

        return orderRepository.save(order);
    }
}
