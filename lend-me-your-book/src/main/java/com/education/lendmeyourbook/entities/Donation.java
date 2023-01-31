package com.education.lendmeyourbook.entities;

import lombok.Data;

import java.util.List;

@Data
public class Donation {
    private School school;
    private User user;
    private List<Book> books;
}
