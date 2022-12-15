package com.education.lendmeyourbook.services;

import com.education.lendmeyourbook.entities.City;
import com.education.lendmeyourbook.entities.State;
import com.education.lendmeyourbook.repositories.CityRepository;
import com.education.lendmeyourbook.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.logging.Logger;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;

    @Autowired
    StateRepository stateRepository;

    @Transactional
    public City save(City city){

        if(city.getState().getId()==null){
            State state =stateRepository.findByName(city.getState().getName());
            if(state==null){
                state = stateRepository.save(city.getState());
            }
            city.setState(state);
        }
        city = cityRepository.save(city);
        return city;
    }
}
