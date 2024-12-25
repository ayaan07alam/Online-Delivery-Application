package com.ayaan.onlineDeliveryApplication.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "users")
@NoArgsConstructor
public class User {

        @Id
        private String id;
        private String username;
        private String email;
        private String password;
        private Set<Role> roles;
    }
