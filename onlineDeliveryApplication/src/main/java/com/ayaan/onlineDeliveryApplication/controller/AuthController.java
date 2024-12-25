package com.ayaan.onlineDeliveryApplication.controller;

import com.ayaan.onlineDeliveryApplication.entity.Role;
import com.ayaan.onlineDeliveryApplication.entity.User;
import com.ayaan.onlineDeliveryApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user, @RequestParam String role) {
        try {
            Role userRole = Role.valueOf(role.toUpperCase());
            userService.registerUser(user, Set.of(userRole));
            return ResponseEntity.ok("User registered successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid role provided");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Public Endpoint is accessible!");
    }
}
