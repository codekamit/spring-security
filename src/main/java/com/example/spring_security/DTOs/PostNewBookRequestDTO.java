package com.example.spring_security.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostNewBookRequestDTO {
    private String bookName;
    private String bookGenre;
    private String bookPublishedDate;
}
