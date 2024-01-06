package com.example.spring_security.security.configurations;

import com.example.spring_security.exceptions.UserNotFoundException;
import com.example.spring_security.security.models.MyUserDetails;
import com.example.spring_security.security.models.SecurityUser;
import com.example.spring_security.security.repositories.SecurityUserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final SecurityUserRepository userRepository;
    public MyUserDetailsService(SecurityUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UserNotFoundException> supplier = () -> {
            return new UserNotFoundException("User with username- "+username+ " not found.");
        };

        SecurityUser securityUser = userRepository
                .findByUsername(username)
                .orElseThrow(supplier);

        return new MyUserDetails(securityUser);
    }
}
