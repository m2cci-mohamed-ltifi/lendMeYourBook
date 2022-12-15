package com.education.lendmeyourbook.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "book_category")
@Data
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private CategoryName name;
    //book or parascolaire
    private String type;

    @OneToMany(mappedBy="category")
    @JsonBackReference(value = "categoryBooks")
    private List<Book> books;
}
