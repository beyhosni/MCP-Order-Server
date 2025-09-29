package com.example.mcporder.service;

import com.example.mcporder.model.Order;
import com.example.mcporder.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public Optional<Order> findByOrderNumber(String orderNumber) {
        return repo.findByOrderNumber(orderNumber);
    }

    public Order save(Order order) {
        return repo.save(order);
    }
}
