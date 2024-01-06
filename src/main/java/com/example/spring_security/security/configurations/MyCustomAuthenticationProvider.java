package com.example.spring_security.security.configurations;

import com.example.spring_security.security.models.MyUserDetails;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MyCustomAuthenticationProvider implements AuthenticationProvider {
    private final MyUserDetailsService userDetailsService;
    private final PasswordManagement passwordManagement;
    public MyCustomAuthenticationProvider(MyUserDetailsService userDetailsService,
                                          PasswordManagement passwordManagement) {
        this.userDetailsService = userDetailsService;
        this.passwordManagement = passwordManagement;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        MyUserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(passwordManagement.bCryptPasswordEncoder().matches(password,
                userDetails.getPassword())) {
            return new UsernamePasswordAuthenticationToken(username,
                    password,
                    userDetails.getAuthorities());
        }
        else {
            throw new BadCredentialsException("Something went wrong.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
