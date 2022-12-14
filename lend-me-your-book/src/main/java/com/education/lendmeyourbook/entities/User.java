package com.education.lendmeyourbook.entities;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Long cinNum;

    @OneToMany(mappedBy = "user")
    private List<UserBorrowedBook> borrowedBooks;

    @ManyToOne
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    private Adress adress;

}
