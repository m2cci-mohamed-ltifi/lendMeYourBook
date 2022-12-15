package com.education.lendmeyourbook.controllers;

import com.education.lendmeyourbook.entities.City;
import com.education.lendmeyourbook.repositories.CityRepository;
import com.education.lendmeyourbook.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> list(){
        return cityRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<City> getCity(@PathVariable Long id){
        Optional<City> city = cityRepository.findById(id);
        return ResponseEntity.ok(city.get());
    }

    @PostMapping(value="/create", consumes = {"application/json"})
    public ResponseEntity<City> registerCity(@RequestBody City city){
        city = cityService.save(city);
        return ResponseEntity.ok(city);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteCity(@PathVariable Long id){
        cityRepository.deleteById(id);
    }
}
