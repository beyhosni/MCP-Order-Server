package com.example.mcporder.tools;

import com.example.mcporder.model.Order;
import com.example.mcporder.service.OrderService;
import org.springframework.stereotype.Component;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Component
public class OrderTools {

    private final OrderService orderService;
    private final ChatClient chatClient;

    @Autowired
    public OrderTools(OrderService orderService, ChatClient.Builder chatClientBuilder) {
        this.orderService = orderService;
        this.chatClient = chatClientBuilder.build();
    }

    public Order getOrderDetails(String orderNumber) {
        Optional<Order> order = orderService.findByOrderNumber(orderNumber);
        return order.orElse(null);
    }

    public String processOrderQuery(String query) {
        return chatClient.prompt()
                .user("Voici la question de l'utilisateur sur les commandes: " + query)
                .call()
                .content();
    }
}
