package com.ayaan.onlineDeliveryApplication.service;

import com.ayaan.onlineDeliveryApplication.entity.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayaan.onlineDeliveryApplication.repository.DeliveryRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery assignDelivery(String orderId, String deliveryPersonnelId, String customerId) {
        Delivery delivery = new Delivery();
        delivery.setOrderId(orderId);
        delivery.setDeliveryPersonnelId(deliveryPersonnelId);
        delivery.setStatus("Assigned");
        delivery.setUpdatedAt(LocalDateTime.now());
        delivery.setCustomerId(customerId);
        return deliveryRepository.save(delivery);
    }

    public List<Delivery> getDeliveriesByCustomerId(String customerId) {
        return deliveryRepository.findByCustomerId(customerId);
    }

    public List<Delivery> getDeliveriesByPersonnelId(String personnelId) {
        return deliveryRepository.findByDeliveryPersonnelId(personnelId);
    }

    public Delivery updateDeliveryStatus(String deliveryId, String status) {
        Optional<Delivery> deliveryOptional = deliveryRepository.findById(deliveryId);
        if (deliveryOptional.isPresent()) {
            Delivery delivery = deliveryOptional.get();
            delivery.setStatus(status);
            delivery.setUpdatedAt(LocalDateTime.now());
            return deliveryRepository.save(delivery);
        }
        throw new RuntimeException("Delivery not found");
    }
}
