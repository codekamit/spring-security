package com.example.spring_security.services;

import com.example.spring_security.models.Author;
import com.example.spring_security.models.Book;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IAuthorService {
    Author getAuthorById(UUID id);
    List<Author> getAllAuthors();
    void addAuthor(Author author);
    Book addBookToExisitingAuthor(Book book, Author author);
    Author addNewAuthor(Author author, @Nullable Book book);
}
