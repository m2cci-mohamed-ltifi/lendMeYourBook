package com.education.lendmeyourbook.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "school")
@Data
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @OneToMany(mappedBy = "school")
    private List<SchoolHasBook> books;

    @ManyToOne
    private City city;
}
