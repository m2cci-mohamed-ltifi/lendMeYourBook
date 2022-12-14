package com.education.lendmeyourbook.entities;

import javax.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

}
