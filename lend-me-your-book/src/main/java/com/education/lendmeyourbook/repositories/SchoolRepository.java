package com.education.lendmeyourbook.repositories;

import com.education.lendmeyourbook.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School,Integer> {

    @Query(value="Select school From School school WHERE school.name=:name AND school.city.id=:id")
    public List<School> findByNameAndAndCityId(@Param("name") String name, @Param("id") Integer id );
}
