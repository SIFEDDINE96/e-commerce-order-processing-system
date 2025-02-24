package com.sifeware.e_commerce_order_processing_system.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class InventoryService {
    private int stock = 100;
    private final ReentrantLock lock = new ReentrantLock();

    public boolean reduceStock(int quantity) {
        lock.lock();
        try {
            if (stock >= quantity) {
                stock -= quantity;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }
}
