package com.example.spring_security.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DeleteAuthorResponseDTO {
    private LocalDateTime timeStamp;
    private String message;
}
