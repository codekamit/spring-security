package com.example.spring_security.controllers;

import com.example.spring_security.security.DTOs.AddNewSecurityUserRequestDTO;
import com.example.spring_security.security.DTOs.AddNewSecurityUserResponseDTO;
import com.example.spring_security.security.models.Authority;
import com.example.spring_security.security.models.EncryptionAlgorithm;
import com.example.spring_security.security.models.SecurityUser;
import com.example.spring_security.security.repositories.SecurityUserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/securityuser")
public class SecurityUserController {
    private final SecurityUserRepository userRepository;
    public SecurityUserController(SecurityUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("")
    public AddNewSecurityUserResponseDTO addNewSecurityUser(@RequestBody AddNewSecurityUserRequestDTO request) {
        SecurityUser securityUser = new SecurityUser();
        securityUser.setUserName(request.getUserName());
        securityUser.setPassword(request.getPassword());
        securityUser.setAlgorithm(EncryptionAlgorithm.BCRYPT);

        List<Authority> authorities = request
                .getRoles()
                .stream()
                .map(x -> {
                    Authority authority = new Authority();
                    authority.setName(x);
                    authority.setUser(securityUser);
                    return authority;
                })
                .toList();

        securityUser.setAuthorities(authorities);
        SecurityUser savedUser = userRepository.save(securityUser);
        AddNewSecurityUserResponseDTO response = new AddNewSecurityUserResponseDTO();
        response.setUserId(savedUser.getId().toString());
        response.setUserName(savedUser.getUsername());
        List<String> roles = savedUser
                .getAuthorities()
                .stream()
                .map(Authority::getName)
                .toList();
        response.setRoles(roles);
        return response;
    }
}
