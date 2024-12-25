package com.ayaan.onlineDeliveryApplication.controller;

import com.ayaan.onlineDeliveryApplication.entity.Order;
import com.ayaan.onlineDeliveryApplication.entity.OrderStatus;
import com.ayaan.onlineDeliveryApplication.service.CartService;
import com.ayaan.onlineDeliveryApplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @PostMapping("/orders")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order placedOrder = orderService.placeOrder(order);
        cartService.clearCart(order.getCustomerId());
        return ResponseEntity.ok(placedOrder);
    }

    @GetMapping("/orders/history")
    public ResponseEntity<List<Order>> getOrderHistory(@RequestParam String customerId) {
        return ResponseEntity.ok(orderService.getOrderHistory(customerId));
    }

    @PatchMapping("/orders/{id}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable String id, @RequestParam OrderStatus status) {
        return ResponseEntity.ok(orderService.updateOrderStatus(id, status));
    }
}
