package com.example.spring_security.security.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
public class AddNewSecurityUserRequestDTO {
    private String userName;
    private String password;
    private List<String> roles;
}
