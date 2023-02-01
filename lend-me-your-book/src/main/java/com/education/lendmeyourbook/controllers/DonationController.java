package com.education.lendmeyourbook.controllers;

import com.education.lendmeyourbook.entities.Book;
import com.education.lendmeyourbook.entities.Donation;
import com.education.lendmeyourbook.repositories.BookRepository;
import com.education.lendmeyourbook.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("donation")
@CrossOrigin("http://localhost:4200")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerDonation(@RequestBody Donation donation){
        //System.out.println(donation.getBooks().get(0).getCategory().getName());
        this.donationService.registerDonation(donation);
    }
}
