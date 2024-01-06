package com.example.spring_security.security.repositories;

import com.example.spring_security.security.models.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser, UUID> {
    Optional<SecurityUser> findByUsername(String username);
}
