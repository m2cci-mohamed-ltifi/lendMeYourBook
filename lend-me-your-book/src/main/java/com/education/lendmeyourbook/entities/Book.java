package com.education.lendmeyourbook.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    private int totalNumber;

    @ManyToOne
    private BookCategory category;

    @OneToMany(mappedBy = "book")
    private List<UserBorrowedBook> borrowingUsers;

    @OneToMany(mappedBy = "book")
    private List<SchoolHasBook> schools;

}
