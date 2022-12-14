package com.education.lendmeyourbook.entities;

import javax.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name="state")
@Data
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "state")
    private Set<City> cities;
}
