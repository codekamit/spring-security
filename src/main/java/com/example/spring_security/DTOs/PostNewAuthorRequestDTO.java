package com.example.spring_security.DTOs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PostNewAuthorRequestDTO {
    private String authorName;
    private int authorAge;
    private String bookName;
    private String bookGenre;
    private String bookPublishedDate;
}
