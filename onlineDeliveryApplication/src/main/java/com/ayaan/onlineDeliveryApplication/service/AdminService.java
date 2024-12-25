package com.ayaan.onlineDeliveryApplication.service;

import com.ayaan.onlineDeliveryApplication.entity.Order;
import com.ayaan.onlineDeliveryApplication.entity.OrderStatus;
import com.ayaan.onlineDeliveryApplication.entity.Product;
import com.ayaan.onlineDeliveryApplication.entity.User;
import com.ayaan.onlineDeliveryApplication.repository.DeliveryRepository;
import com.ayaan.onlineDeliveryApplication.repository.OrderRepository;
import com.ayaan.onlineDeliveryApplication.repository.ProductRepository;
import com.ayaan.onlineDeliveryApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    // User Management
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    // Product Management
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(String productId, Product product) {
        if (productRepository.existsById(productId)) {
            product.setId(productId);
            return productRepository.save(product);
        }
        throw new RuntimeException("Product not found");
    }

    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }

    // Order Management
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrderStatus(String orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }

    // Delivery Management
    public List<Order> getAllDeliveries() {
        return orderRepository.findAll(); // Consider adding a separate Delivery repository if necessary
    }

    public Order updateDeliveryStatus(String deliveryId, OrderStatus status) {
        Order order = orderRepository.findById(deliveryId).orElseThrow(() -> new RuntimeException("Delivery not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }

    // Reports
    public String generateSalesReport() {
        // Here, you can aggregate data for the sales report
        return "Sales Report: Total Sales, Orders, Products Sold...";
    }

    public String generateUserActivityReport() {
        // Here, you can aggregate data for the user activity report
        return "User Activity Report: Active Users, Last Login, etc...";
    }

    public String generateDeliveryPerformanceReport() {
        // Here, you can aggregate data for delivery performance
        return "Delivery Performance Report: On-Time Deliveries, Pending Deliveries...";
    }
}
