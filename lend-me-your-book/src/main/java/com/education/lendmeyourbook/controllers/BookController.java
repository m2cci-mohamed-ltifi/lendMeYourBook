package com.education.lendmeyourbook.controllers;

import com.education.lendmeyourbook.entities.Book;
import com.education.lendmeyourbook.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public List<Book> list(){
        return bookRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id){
        Optional<Book> book = bookRepository.findById(id);
        return ResponseEntity.ok(book.get());
    }

    @PostMapping("/create")
    public ResponseEntity<Book> registerBook(@RequestBody Book book){

        book = bookRepository.saveAndFlush(book);
        return ResponseEntity.ok(book);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable Integer id){
        bookRepository.deleteById(id);
    }

}
