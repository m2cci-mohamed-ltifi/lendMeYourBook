package com.education.lendmeyourbook.repositories;

import com.education.lendmeyourbook.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {
}
