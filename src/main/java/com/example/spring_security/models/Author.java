package com.example.spring_security.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Getter
@Setter
public class Author extends BaseModel {
    private String fullName;
    private int age;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "author",
            orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        this.books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
        book.setAuthor(null);
    }

    public void removeBooks(List<Book> books) {
        Iterator<Book> iterator = books.iterator();
        while(iterator.hasNext()) {
            Book book = iterator.next();
            this.removeBook(book);
        }
    }
}
