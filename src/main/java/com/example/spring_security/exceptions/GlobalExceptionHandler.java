package com.example.spring_security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@RestControllerAdvice
public class GlobalExceptionHandler extends ExceptionHandlerExceptionResolver {

    @ExceptionHandler(AuthorNotFoundException.class)
    @ResponseStatus(value = HttpStatus.OK, reason = "Author not found")
    public void handleAuthorNotFound() {
        throw new AuthorNotFoundException();
    }

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Book not found")
    public void handleBookNotFound() {
        throw new BookNotFoundException();
    }
}
