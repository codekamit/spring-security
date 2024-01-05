package com.example.spring_security.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostNewAuthorResponseDTO {
    private String authorId;
    private String authorName;
    private int authorAge;
}
