package com.example.spring_security.services;

import com.example.spring_security.exceptions.BookNotFoundException;
import com.example.spring_security.models.Author;
import com.example.spring_security.models.Book;
import com.example.spring_security.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Supplier;

@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository  bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public Book getBook(UUID bookId) {
        Supplier<BookNotFoundException> supplier = () -> {
            return new BookNotFoundException("The book with id : "+bookId+ " not found.");
        };
        return bookRepository
                .findById(bookId)
                .orElseThrow(supplier);
    }
}
