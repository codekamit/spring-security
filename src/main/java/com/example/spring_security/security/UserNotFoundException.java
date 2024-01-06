package com.example.spring_security.security;

import org.springframework.security.core.userdetails.UserDetailsService;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
