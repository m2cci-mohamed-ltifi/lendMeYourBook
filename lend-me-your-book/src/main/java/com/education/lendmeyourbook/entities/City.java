package com.education.lendmeyourbook.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "city")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @ManyToOne
    private State state;

    @OneToMany(mappedBy = "city")
    @JsonBackReference(value = "citySchools")
    private List<School> schools;
}
