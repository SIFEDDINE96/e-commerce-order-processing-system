package com.sifeware.e_commerce_order_processing_system.dao;

import com.sifeware.e_commerce_order_processing_system.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
