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
    @Column(name = "id")
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private Integer cinNum;

    private Integer level;

    @OneToMany(mappedBy = "user")
    private List<UserBorrowedBook> borrowedBooks;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Adress adress;

}
