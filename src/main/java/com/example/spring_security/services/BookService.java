package com.example.spring_security.services;

import com.example.spring_security.exceptions.BookNotFoundException;
import com.example.spring_security.models.Author;
import com.example.spring_security.models.Book;
import com.example.spring_security.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository  bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public Book getBook(UUID bookId) {
        return bookRepository
                .findById(bookId)
                .orElseThrow(BookNotFoundException::new);
    }

    @Override
    @Transactional
    public void removeBook(UUID bookId) {
        Book book = getBook(bookId);
        Author author = book.getAuthor();
        author.removeBook(book);
    }
}
