package com.education.lendmeyourbook.repositories;

import com.education.lendmeyourbook.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State,Long> {
    public State findByName(String name);
}
