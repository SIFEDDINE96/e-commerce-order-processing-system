package com.sifeware.e_commerce_order_processing_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private Long quantity;
    private String status;
    private LocalDateTime orderTime;

    public Order(String product, Long quantity, String processing) {
    }
}
