package com.education.lendmeyourbook.entities;

public enum CategoryName {
    SCIENCE("Science"),MATH("Math"),TECHNOLOGY("Technology"),ARABIC("Arabic"),FRENCH("French"),ENGLISH("English"),CIVIC_EDUCATION("Civic Education"),ISLAMIC_EDUCATION("Islamic education"),ART("Art"),SPORT("Sport"),HISTORY_GEOGRAPHY("History and geography");

    private String displayName;

    private CategoryName(String name){this.displayName=name;}

    public String toString() {
        return this.displayName;
    }
}
