package com.example.spring_security.services;

import com.example.spring_security.models.Author;
import com.example.spring_security.models.Book;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface IBookService {
    Book getBook(UUID bookId);
}
