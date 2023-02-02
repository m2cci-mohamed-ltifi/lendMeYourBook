package com.education.lendmeyourbook.controllers;

import com.education.lendmeyourbook.entities.CategoryName;
import com.education.lendmeyourbook.repositories.BookCategoryRepository;
import com.education.lendmeyourbook.entities.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookCategories")
public class BookCategoryController {

    @Autowired
    BookCategoryRepository bookCategoryRepository;

    @GetMapping
    public List<BookCategory> list(){
        return bookCategoryRepository.findAll();
    }

    @GetMapping("/categoryNames")
    public List<CategoryName> listCategoryNames(){
        return Arrays.asList(CategoryName.values());
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<BookCategory> getBookCategory(@PathVariable Integer id){
        Optional<BookCategory> bookCategory = bookCategoryRepository.findById(id);
        return ResponseEntity.ok(bookCategory.get());
    }

    @PostMapping("/create")
    public ResponseEntity<BookCategory> registerBookCategory(@RequestBody BookCategory bookCategory){
        bookCategory = bookCategoryRepository.saveAndFlush(bookCategory);
        return ResponseEntity.ok(bookCategory);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteBookCategory(@PathVariable Integer id){
        bookCategoryRepository.deleteById(id);
    }
}
