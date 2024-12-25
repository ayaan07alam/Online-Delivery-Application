package com.ayaan.onlineDeliveryApplication.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "orders")
@Data
public class Order {

    @Id
    private String id;
    private String customerId;
    private List<String> productIds; // Store product IDs
    private double totalPrice;
    private OrderStatus status;
    private LocalDateTime orderDate;

}