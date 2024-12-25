package com.ayaan.onlineDeliveryApplication.controller;

import com.ayaan.onlineDeliveryApplication.entity.Order;
import com.ayaan.onlineDeliveryApplication.entity.Product;
import com.ayaan.onlineDeliveryApplication.entity.User;
import com.ayaan.onlineDeliveryApplication.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // User management
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = adminService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        adminService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

    // Product management
    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = adminService.addProduct(product);
        return ResponseEntity.ok(addedProduct);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable String productId, @RequestBody Product product) {
        Product updatedProduct = adminService.updateProduct(productId, product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productId) {
        adminService.deleteProduct(productId);
        return ResponseEntity.ok("Product deleted successfully");
    }

    // Order management
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = adminService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/orders/{orderId}")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable String orderId, @RequestParam String status) {
        Order updatedOrder = adminService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok(updatedOrder);
    }

    // Delivery management
    @GetMapping("/deliveries")
    public ResponseEntity<List<Order>> getAllDeliveries() {
        List<Order> deliveries = adminService.getAllDeliveries();
        return ResponseEntity.ok(deliveries);
    }

    @PutMapping("/deliveries/{deliveryId}")
    public ResponseEntity<Order> updateDeliveryStatus(@PathVariable String deliveryId, @RequestParam String status) {
        Order updatedDelivery = adminService.updateDeliveryStatus(deliveryId, status);
        return ResponseEntity.ok(updatedDelivery);
    }

    // Reporting
    @GetMapping("/report/sales")
    public ResponseEntity<String> generateSalesReport() {
        String report = adminService.generateSalesReport();
        return ResponseEntity.ok(report);
    }

    @GetMapping("/report/userActivity")
    public ResponseEntity<String> generateUserActivityReport() {
        String report = adminService.generateUserActivityReport();
        return ResponseEntity.ok(report);
    }

    @GetMapping("/report/deliveryPerformance")
    public ResponseEntity<String> generateDeliveryPerformanceReport() {
        String report = adminService.generateDeliveryPerformanceReport();
        return ResponseEntity.ok(report);
    }
}