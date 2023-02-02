package com.education.lendmeyourbook.controllers;


import com.education.lendmeyourbook.entities.School;
import com.education.lendmeyourbook.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    @Autowired
    SchoolRepository schoolRepository;

    @GetMapping
    public List<School> list(){
        return schoolRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<School> getSchool(@PathVariable Integer id){
        Optional<School> school = schoolRepository.findById(id);
        return ResponseEntity.ok(school.get());
    }

    @PostMapping(value="/create", consumes = {"application/json"})
    public ResponseEntity<School> registerSchool(@RequestBody School school){
        school = schoolRepository.save(school);
        return ResponseEntity.ok(school);
    }

}
