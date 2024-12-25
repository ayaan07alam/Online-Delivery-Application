package com.ayaan.onlineDeliveryApplication.repository;

import com.ayaan.onlineDeliveryApplication.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findByCustomerId(String customerId);
}
