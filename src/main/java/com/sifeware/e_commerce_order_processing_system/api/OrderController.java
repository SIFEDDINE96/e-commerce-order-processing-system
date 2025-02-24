package com.sifeware.e_commerce_order_processing_system.api;

import com.sifeware.e_commerce_order_processing_system.model.Order;
import com.sifeware.e_commerce_order_processing_system.service.OrderService;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public CompletableFuture<Order> placeOrder(@RequestParam String product, @RequestParam Long quantity) {
        return orderService.processOrder(product, quantity);
    }
}
