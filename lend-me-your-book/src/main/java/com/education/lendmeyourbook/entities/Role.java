package com.education.lendmeyourbook.entities;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @OneToMany(mappedBy = "role")
    private List<User> users;
}
