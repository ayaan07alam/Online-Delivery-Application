package com.ayaan.onlineDeliveryApplication.repository;

import com.ayaan.onlineDeliveryApplication.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByCategory(String category);
    List<Product> findBySubcategory(String subcategory);
}
