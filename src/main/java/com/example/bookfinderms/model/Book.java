package com.example.bookfinderms.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "books")
public class Book {

    @Id
    int book_id;
    String book_name;
    String author;

    public Book() {
    }

    public Book(int book_id, String book_name, String author) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author = author;
    }
}
