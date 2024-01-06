package com.example.spring_security.controllers;

import com.example.spring_security.DTOs.*;
import com.example.spring_security.models.Author;
import com.example.spring_security.models.Book;
import com.example.spring_security.services.AuthorServiceUtil;
import com.example.spring_security.services.BookServiceUtil;
import com.example.spring_security.services.IAuthorService;
import com.example.spring_security.services.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final IAuthorService authorService;
    private final IBookService bookService;
    public AuthorController(IAuthorService authorService,
                            IBookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("{id}")
    public ResponseEntity<GetAuthorResponseDTO> getAuthorById(@PathVariable("id") String authorId) {
        Author author = authorService.getAuthorById(UUID.fromString(authorId));
        GetAuthorResponseDTO response = new GetAuthorResponseDTO();
                response.setAuthorId(author.getId().toString());
                response.setAuthorName(author.getFullName());
                response.setAuthorAge(author.getAge());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("")
    public ResponseEntity<List<GetAuthorResponseDTO>> getAllAuthors() {
        List<GetAuthorResponseDTO> response = authorService
                .getAllAuthors()
                .stream()
                .map(AuthorServiceUtil::convertToDTO)
                .toList();

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("{id}")
    public ResponseEntity<PostNewBookResponseDTO> addNewBookToExistingAuthor(@PathVariable("id") String authorId,
                                                                @RequestBody PostNewBookRequestDTO request) {
        Author author = authorService.getAuthorById(UUID.fromString(authorId));
        Book book = BookServiceUtil.convertDTOtoBook(request);
        Book savedBook = authorService.addBookToExisitingAuthor(book, author);
        PostNewBookResponseDTO response = new PostNewBookResponseDTO();
                response.setBookId(savedBook.getId().toString());
                response.setBookName(savedBook.getBookName());
                response.setAuthorName(author.getFullName());
                response.setBookGenre(savedBook.getGenre());
                response.setBookPublishedDate(savedBook.getPublishDate().toString());
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("")
    public ResponseEntity<PostNewAuthorResponseDTO> addNewAuthor(@RequestBody PostNewAuthorRequestDTO request) {
        Book book = new Book();
        book.setBookName(request.getBookName());
        book.setGenre(request.getBookGenre());
        book.setPublishDate(LocalDate.parse(request.getBookPublishedDate()));

        Author author = new Author();
        author.setFullName(request.getAuthorName());
        author.setAge(request.getAuthorAge());

        Author savedAuthor = authorService.addNewAuthor(author, book);
        PostNewAuthorResponseDTO response = new PostNewAuthorResponseDTO();
                response.setAuthorId(savedAuthor.getId().toString());
                response.setAuthorName(savedAuthor.getFullName());
                response.setAuthorAge(savedAuthor.getAge());
        return ResponseEntity.ok().body(response);
    }
}
