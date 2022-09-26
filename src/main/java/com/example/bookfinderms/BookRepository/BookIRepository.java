package com.example.bookfinderms.BookRepository;

import com.example.bookfinderms.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookIRepository extends JpaRepository<Book, Integer> {

}
