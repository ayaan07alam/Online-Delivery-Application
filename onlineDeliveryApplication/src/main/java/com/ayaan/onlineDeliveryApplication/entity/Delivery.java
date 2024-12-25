package com.ayaan.onlineDeliveryApplication.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "deliveries")
@Data
public class Delivery {
    @Id
    private String id;
    private String orderId;
    private String deliveryPersonnelId;
    private String status; // e.g., "Assigned", "Out for Delivery", "Delivered", "Canceled"
    private LocalDateTime updatedAt;
    private String customerId;
}
