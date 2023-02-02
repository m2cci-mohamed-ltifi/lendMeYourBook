package com.education.lendmeyourbook.repositories;

import com.education.lendmeyourbook.entities.Book;
import com.education.lendmeyourbook.entities.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query(value="Select book From Book book WHERE book.name=:name AND book.category.id=:categoryId")
    public List<Book> findBookByNameAndCategoryId(@Param("name") String name, @Param("categoryId") Integer bcId);
}
