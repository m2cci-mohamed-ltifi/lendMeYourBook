package com.education.lendmeyourbook.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name",nullable = false)
    private String lastName;

    @Column(name="email",nullable = false)
    private String email;

    private Long cinNum;

    @OneToMany(mappedBy = "user")
    private List<UserBorrowedBook> borrowedBooks;

    @ManyToOne
    private Role role;

    @OneToOne
    private Adress adress;

}
