package com.example.spring_security.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Book extends BaseModel {
    private String bookName;
    private String genre;
    private LocalDate publishDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        if(obj.getClass() != this.getClass()) {
            return false;
        }
        return this.getId() == ((Book) obj).getId();
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", genre='" + genre + '\'' +
                "} " + super.toString();
    }
}
