package com.education.lendmeyourbook.repositories;

import com.education.lendmeyourbook.entities.Book;
import com.education.lendmeyourbook.entities.SchoolHasBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolHasBookRepository extends JpaRepository<SchoolHasBook,Integer> {

    @Query(value="Select shb From SchoolHasBook shb WHERE shb.school.id=:school_id AND shb.book.id=:book_id")
    public List<SchoolHasBook> findSchoolHasBookBySchoolIdAndBookId(@Param("school_id") Integer schoolId, @Param("book_id") Integer bookId);

}
