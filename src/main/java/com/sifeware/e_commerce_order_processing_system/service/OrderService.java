package com.sifeware.e_commerce_order_processing_system.service;

import com.sifeware.e_commerce_order_processing_system.dao.OrderRepository;
import com.sifeware.e_commerce_order_processing_system.model.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Async
    public CompletableFuture<Order> processOrder(String product, Long quantity) {
        Order order = new Order(product, quantity, "PROCESSING");
        order = orderRepository.save(order);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        order.setStatus("COMPLETED");
        orderRepository.save(order);
        return CompletableFuture.completedFuture(order);
    }
}
