package com.example.mcporder.tools;

import com.example.mcporder.model.Order;
import com.example.mcporder.service.OrderService;
import org.springframework.stereotype.Component;
// Les annotations exactes peuvent varier selon la version de Spring AI.
// Adapte les imports si nécessaire.
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

import java.util.Optional;

@Component
public class OrderTools {

    private final OrderService orderService;

    public OrderTools(OrderService orderService) {
        this.orderService = orderService;
    }

    @Tool(name = "getOrderByNumber",
          description = "Récupère les détails d'une commande par son numéro")
    public Order getOrderByNumber(@ToolParam(name = "orderNumber", description = "Numéro de commande") String orderNumber) {
        Optional<Order> o = orderService.findByOrderNumber(orderNumber);
        return o.orElse(null);
    }
}
