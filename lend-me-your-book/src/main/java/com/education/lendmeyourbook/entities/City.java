package com.education.lendmeyourbook.entities;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "city")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @ManyToOne
    private State state;

    @OneToMany(mappedBy = "city")
    private List<School> schools;
}
