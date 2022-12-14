package com.education.lendmeyourbook.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="user_borrowed_book")
@Data
public class UserBorrowedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

}
