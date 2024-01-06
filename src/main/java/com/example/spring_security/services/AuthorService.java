package com.example.spring_security.services;

import com.example.spring_security.exceptions.AuthorNotFoundException;
import com.example.spring_security.exceptions.BookNotFoundException;
import com.example.spring_security.models.Author;
import com.example.spring_security.models.Book;
import com.example.spring_security.repositories.AuthorRepository;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class AuthorService implements IAuthorService {
    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    @Transactional
    public Author getAuthorById(UUID authorId) {
        Supplier<AuthorNotFoundException> supplier = () -> {
            return new AuthorNotFoundException("The author with id : "+authorId+ " not found.");
        };
        return authorRepository
                .findById(authorId)
                .orElseThrow(supplier);
    }

    @Override
    @Transactional
    public Book addBookToExisitingAuthor(Book book, Author author) {
        author.addBook(book);
        return book;
    }

    @Override
    @Transactional
    public Author addNewAuthor(Author author, @Nullable Book book) {
        if(book != null) {
            author.addBook(book);
        }
        return authorRepository.save(author);
    }

    @Override
    @Transactional
    public void deleteBook(Author author, Book book) {
        author.removeBook(book);
    }

    @Override
    @Transactional
    public List<Author> getAllAuthors() {
        return authorRepository
                .findAll();
    }

    @Override
    @Transactional
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }
}
