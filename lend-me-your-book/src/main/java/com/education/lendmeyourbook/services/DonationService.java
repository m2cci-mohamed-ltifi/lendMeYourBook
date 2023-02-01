package com.education.lendmeyourbook.services;

import com.education.lendmeyourbook.entities.Book;
import com.education.lendmeyourbook.entities.BookCategory;
import com.education.lendmeyourbook.entities.Donation;
import com.education.lendmeyourbook.repositories.BookCategoryRepository;
import com.education.lendmeyourbook.repositories.BookRepository;
import com.education.lendmeyourbook.repositories.SchoolRepository;
import com.education.lendmeyourbook.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@Service
public class DonationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Autowired
    DonationService(UserRepository userRepository, BookRepository bookRepository, SchoolRepository schoolRepository){

    }


    @Transactional
    public void registerDonation(Donation donation){
        this.userRepository.saveAndFlush(donation.getUser());
        for(Book book:donation.getBooks()){
            BookCategory category=this.bookCategoryRepository.saveAndFlush(book.getCategory());
            book.setCategory(category);
        }
        this.bookRepository.saveAll(donation.getBooks());
        this.schoolRepository.save(donation.getSchool());
    }
}
