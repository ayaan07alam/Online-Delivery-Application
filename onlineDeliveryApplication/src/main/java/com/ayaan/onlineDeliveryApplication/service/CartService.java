package com.ayaan.onlineDeliveryApplication.service;

import com.ayaan.onlineDeliveryApplication.entity.Cart;
import com.ayaan.onlineDeliveryApplication.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart getCartByCustomerId(String customerId) {
        return cartRepository.findByCustomerId(customerId);
    }

    public Cart addToCart(String customerId, String productId) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        if (cart == null) {
            cart = new Cart();
            cart.setCustomerId(customerId);
        }
        cart.getProductIds().add(productId);
        return cartRepository.save(cart);
    }

    public void clearCart(String customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        if (cart != null) {
            cart.getProductIds().clear();
            cartRepository.save(cart);
        }
    }
}