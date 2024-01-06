package com.example.spring_security.exceptions;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
public class ErrorResponse {
    private LocalDateTime timestamp;
    private String message;
    private HttpStatus httpStatus;
}
