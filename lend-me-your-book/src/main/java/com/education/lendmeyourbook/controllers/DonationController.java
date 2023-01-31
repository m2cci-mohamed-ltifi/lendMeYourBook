package com.education.lendmeyourbook.controllers;

import com.education.lendmeyourbook.entities.Donation;
import com.education.lendmeyourbook.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("donation")
@CrossOrigin("http://localhost:4200")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping
    public void registerDonation(@RequestBody Donation donation){
        this.donationService.registerDonation(donation);
    }
}
