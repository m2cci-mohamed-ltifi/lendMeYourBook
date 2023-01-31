package com.education.lendmeyourbook.services;

import com.education.lendmeyourbook.entities.Book;
import com.education.lendmeyourbook.entities.Donation;
import com.education.lendmeyourbook.repositories.BookRepository;
import com.education.lendmeyourbook.repositories.SchoolRepository;
import com.education.lendmeyourbook.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationService {
    private UserRepository userRepository;
    private BookRepository bookRepository;
    private SchoolRepository schoolRepository;

    @Autowired
    DonationService(UserRepository userRepository, BookRepository bookRepository, SchoolRepository schoolRepository){

    }

    public void registerDonation(Donation donation){
        this.userRepository.save(donation.getUser());
        this.bookRepository.saveAll(donation.getBooks());
        this.schoolRepository.save(donation.getSchool());
    }
}
