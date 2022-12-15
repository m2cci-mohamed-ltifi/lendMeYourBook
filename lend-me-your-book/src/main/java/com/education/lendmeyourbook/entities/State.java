package com.education.lendmeyourbook.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name="state")
@Data
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",unique = true)
    private String name;

    @OneToMany(mappedBy = "state")
    @JsonBackReference(value = "cities")
    private Set<City> cities;
}
