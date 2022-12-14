package com.education.lendmeyourbook.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="adress")
@Data
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String postalCode;

    @ManyToOne
    private City city;

    private State state;

}
