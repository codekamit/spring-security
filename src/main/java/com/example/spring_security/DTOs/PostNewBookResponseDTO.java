package com.example.spring_security.DTOs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostNewBookResponseDTO {
    private String bookId;
    private String bookName;
    private String authorName;
    private String bookGenre;
    private String bookPublishedDate;
}
