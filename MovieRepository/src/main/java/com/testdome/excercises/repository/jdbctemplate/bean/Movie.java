package com.testdome.excercises.repository.jdbctemplate.bean;

public class Movie {
    public String name;
    public int year;
    public int rating;
    
    public Movie(String name, int year, int rating) {
        this.name = name;
        this.year = year;
        this.rating = rating;
    }
}
