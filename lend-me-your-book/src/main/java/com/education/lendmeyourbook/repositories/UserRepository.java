package com.education.lendmeyourbook.repositories;

import com.education.lendmeyourbook.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
