package com.example.spring_security.controllers;

import com.example.spring_security.models.Author;
import com.example.spring_security.models.Book;
import com.example.spring_security.services.IAuthorService;
import com.example.spring_security.services.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {
    private final IAuthorService authorService;
    private final IBookService bookService;
    public BookController(IAuthorService authorService,
                            IBookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") String bookId, @RequestParam String authorId) {
        Author author = authorService.getAuthorById(UUID.fromString(authorId));
        Book book = bookService.getBook(UUID.fromString(bookId));
        authorService.deleteBook(author, book);
        return new ResponseEntity<String>("The book : " +book.getBookName() + ", was successfully deleted", HttpStatus.OK);
    }
}
