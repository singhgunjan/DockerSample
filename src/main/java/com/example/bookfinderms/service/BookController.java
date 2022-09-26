package com.example.bookfinderms.service;

import com.example.bookfinderms.BookRepository.BookIRepository;
import com.example.bookfinderms.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class BookController {

    @Autowired
    private BookIRepository bookIRepository;

    @GetMapping("/api/getAllBooks")
    public List<Book> getAllBooks() {

        log.debug("In getAll Books method");
        return bookIRepository.findAll();
    }

    @GetMapping("/api/getBookById/{book_id}")
    public Book getBookById(@PathVariable Integer book_id) {
        Optional<Book> book = bookIRepository.findById(book_id);
        return book.orElse(null);
    }

    @GetMapping("/api/getBookByName/{book_name}")
    public Book getBookByName(@PathVariable String book_name) {
        List<Book> book = bookIRepository.findAll();
        for(Book b: book){
            if(b.getBook_name().equals(book_name)) {
                return b;
            }
        }
        return null;
    }

    @GetMapping("/api/getBookByAuthor/{author}")
    public Book getBookByAuthor(@PathVariable String author) {
        List<Book> book = bookIRepository.findAll();
        for(Book b: book){
            if(b.getAuthor().equals(author)) {
                return b;
            }
        }
        return null;
    }

    @PostMapping("/api/addBook")
    public Book addMember(@RequestBody Book book){
        return bookIRepository.save(book);
    }

    @DeleteMapping("/api/deleteBook/{book_id}")
    public void deleteBook(@PathVariable int book_id) {
        bookIRepository.deleteById(book_id);
    }
}
