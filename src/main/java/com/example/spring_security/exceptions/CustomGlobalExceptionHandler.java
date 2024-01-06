package com.example.spring_security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAuthorNotFound(AuthorNotFoundException ex) {
        ErrorResponse response = ErrorResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleBookNotFound(BookNotFoundException ex) {
        ErrorResponse response = ErrorResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
