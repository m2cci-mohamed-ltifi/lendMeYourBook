package com.education.lendmeyourbook.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;


    @ManyToOne
    private BookCategory category;

    @OneToMany(mappedBy = "book")
    @JsonBackReference(value = "bookBorriwingUsers")
    private List<UserBorrowedBook> borrowingUsers;

    @OneToMany(mappedBy = "book")
    @JsonBackReference(value = "schoolsHavingBook")
    private List<SchoolHasBook> schools;

}
