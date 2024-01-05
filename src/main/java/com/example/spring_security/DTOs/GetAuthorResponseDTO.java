package com.example.spring_security.DTOs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAuthorResponseDTO {
    private String authorId;
    private String authorName;
    private int authorAge;
}
