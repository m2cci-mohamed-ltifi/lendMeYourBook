package com.education.lendmeyourbook.repositories;

import com.education.lendmeyourbook.entities.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory,Long> {
}
