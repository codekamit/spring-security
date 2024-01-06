package com.example.spring_security.security.models;

import com.example.spring_security.models.BaseModel;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Authority extends BaseModel {
    private String name;
    @JoinColumn(name = "user")
    @ManyToOne
    private SecurityUser user;
}
