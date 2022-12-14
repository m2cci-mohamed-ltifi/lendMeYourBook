package com.education.lendmeyourbook.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "school_has_book")
@Data
public class SchoolHasBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private School school;
}
