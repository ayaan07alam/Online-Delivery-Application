package com.ayaan.onlineDeliveryApplication.repository;

import com.ayaan.onlineDeliveryApplication.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByCustomerId(String customerId);
}
