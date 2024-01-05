package com.example.spring_security.services;

import com.example.spring_security.DTOs.GetAuthorRequestDTO;
import com.example.spring_security.DTOs.GetAuthorResponseDTO;
import com.example.spring_security.models.Author;

public class AuthorServiceUtil {

    public static GetAuthorResponseDTO convertToDTO(Author author) {
        GetAuthorResponseDTO response = new GetAuthorResponseDTO();
                response.setAuthorId(author.getId().toString());
                response.setAuthorName(author.getFullName());
                response.setAuthorAge(author.getAge());
                return response;
    }
//
//    public static Author convertToEntity(GetAuthorRequestDTO request) {
//        return null;
//    }
}
