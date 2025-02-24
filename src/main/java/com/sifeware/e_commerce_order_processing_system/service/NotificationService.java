package com.sifeware.e_commerce_order_processing_system.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class NotificationService {
    private final BlockingQueue<String> notificationQueue = new LinkedBlockingQueue<>();

    public void sendNotification(String message) {
        notificationQueue.add(message);
    }

    public void processNotifications() {
        while (true) {
            try {
                String message = notificationQueue.take();
                System.out.println("Sending notification: " + message);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
