package com.education.lendmeyourbook.repositories;

import com.education.lendmeyourbook.entities.BookCategory;
import com.education.lendmeyourbook.entities.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer> {

    @Query(value = "SELECT bc FROM BookCategory bc WHERE bc.name=:name AND bc.level=:level AND bc.type=:type")
    public List<BookCategory> findBookCategoryByNameAndTypeAndLevel(
            @Param("name") CategoryName name,
            @Param("type") String type,
            @Param("level") Integer level
    );
}
