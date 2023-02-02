package com.education.lendmeyourbook.controllers;

import com.education.lendmeyourbook.entities.City;
import com.education.lendmeyourbook.entities.State;
import com.education.lendmeyourbook.repositories.CityRepository;
import com.education.lendmeyourbook.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
@CrossOrigin("http://localhost:4200")
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
    public ResponseEntity<City> getCity(@PathVariable Integer id){
        Optional<City> city = cityRepository.findById(id);
        return ResponseEntity.ok(city.get());
    }

    @PostMapping(value="/create", consumes = {"application/json"})
    public ResponseEntity<City> registerCity(@RequestBody City city){
        city = cityService.save(city);
        return ResponseEntity.ok(city);
    }

    @PostMapping("/createList")
    public List<City> registerStates(@RequestBody List<City> cities){
        List<City> savedCities=new ArrayList<>();
        for(City city:cities){
            try {
                city = cityService.save(city);
                savedCities.add(city);
            } catch (Exception e){}
        }
        return savedCities;
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteCity(@PathVariable Integer id){
        cityRepository.deleteById(id);
    }
}
