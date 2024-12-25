package com.ayaan.onlineDeliveryApplication.repository;

import com.ayaan.onlineDeliveryApplication.entity.Delivery;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DeliveryRepository extends MongoRepository<Delivery, String> {
        List<Delivery> findByCustomerId(String customerId);
        List<Delivery> findByDeliveryPersonnelId(String deliveryPersonnelId);
}
