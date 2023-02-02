package com.education.lendmeyourbook.controllers;

import com.education.lendmeyourbook.entities.Book;
import com.education.lendmeyourbook.entities.Donation;
import com.education.lendmeyourbook.repositories.BookRepository;
import com.education.lendmeyourbook.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public HttpStatus registerDonation(@RequestBody Donation donation){
        try {
            this.donationService.registerDonation(donation);
            return HttpStatus.ACCEPTED;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return HttpStatus.BAD_REQUEST;
        }
    }
}
