package com.example.spring_security.security.models;

import com.example.spring_security.models.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class SecurityUser extends BaseModel {
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private EncryptionAlgorithm algorithm;
    @OneToMany(mappedBy = "user",
    fetch = FetchType.EAGER,
    cascade = {CascadeType.PERSIST, CascadeType.MERGE},
    orphanRemoval = true)
    private List<Authority> authorities;

    public void addRole(Authority authority) {
        this.authorities.add(authority);
        authority.setUser(this);
    }

    public void removeRole(Authority authority) {
        this.authorities.remove(authority);
        authority.setUser(null);
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAlgorithm(EncryptionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
