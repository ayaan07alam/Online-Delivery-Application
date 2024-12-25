package com.ayaan.onlineDeliveryApplication.controller;

import com.ayaan.onlineDeliveryApplication.entity.Delivery;
import com.ayaan.onlineDeliveryApplication.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/assign")
    public ResponseEntity<Delivery> assignDelivery(
            @RequestParam String orderId,
            @RequestParam String deliveryPersonnelId,
            @RequestParam String customerId) {
        Delivery delivery = deliveryService.assignDelivery(orderId, deliveryPersonnelId, customerId);
        return ResponseEntity.ok(delivery);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Delivery>> getDeliveriesByCustomerId(@PathVariable String customerId) {
        List<Delivery> deliveries = deliveryService.getDeliveriesByCustomerId(customerId);
        return ResponseEntity.ok(deliveries);
    }

    @GetMapping("/personnel/{personnelId}")
    public ResponseEntity<List<Delivery>> getDeliveriesByPersonnelId(@PathVariable String personnelId) {
        List<Delivery> deliveries = deliveryService.getDeliveriesByPersonnelId(personnelId);
        return ResponseEntity.ok(deliveries);
    }

    @PatchMapping("/{deliveryId}/status")
    public ResponseEntity<Delivery> updateDeliveryStatus(
            @PathVariable String deliveryId,
            @RequestParam String status) {
        Delivery delivery = deliveryService.updateDeliveryStatus(deliveryId, status);
        return ResponseEntity.ok(delivery);
    }
}
