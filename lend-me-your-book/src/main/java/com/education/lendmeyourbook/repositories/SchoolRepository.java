package com.education.lendmeyourbook.repositories;

import com.education.lendmeyourbook.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Long> {
}
