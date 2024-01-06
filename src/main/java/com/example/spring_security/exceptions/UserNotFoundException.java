package com.example.spring_security.exceptions;

import org.springframework.security.core.userdetails.UserDetailsService;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
