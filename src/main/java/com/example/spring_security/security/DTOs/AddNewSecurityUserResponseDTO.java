package com.example.spring_security.security.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddNewSecurityUserResponseDTO {
    private String userId;
    private String userName;
    private List<String> roles;
}
