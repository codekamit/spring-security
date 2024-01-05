package com.example.spring_security.services;

import com.example.spring_security.DTOs.PostNewBookRequestDTO;
import com.example.spring_security.DTOs.PostNewBookResponseDTO;
import com.example.spring_security.models.Book;

import java.time.LocalDate;

public class BookServiceUtil {

    public static Book convertDTOtoBook(PostNewBookRequestDTO request) {
        Book book = new Book();
        book.setBookName(request.getBookName());
        book.setGenre(request.getBookGenre());
        book.setPublishDate(LocalDate.parse(request.getBookPublishedDate()));
        return book;
    }

    public static PostNewBookResponseDTO convertDTOtoBook(Book book) {
        PostNewBookResponseDTO response = new PostNewBookResponseDTO();
                response.setBookId(book.getId().toString());
                response.setBookName(book.getBookName());
                response.setBookGenre(book.getGenre());
                response.setBookPublishedDate(book.getPublishDate().toString());
                return response;
    }
}
