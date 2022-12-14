package com.education.lendmeyourbook.repositories;

import com.education.lendmeyourbook.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
