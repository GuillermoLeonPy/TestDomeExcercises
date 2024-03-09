package com.testdome.excercises.repository.jdbctemplate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.testdome.excercises.repository.jdbctemplate.bean.Movie;

import jakarta.annotation.PostConstruct;

@Repository
public class MovieRepository {

	@Autowired
    private JdbcTemplate template;

    @PostConstruct
    public void createTable() {
        template.execute("CREATE TABLE movies (id bigint auto_increment primary key, name VARCHAR(50), movie_year int, rating int)");
    }

    public void createMovie(String name, int year, int rating) {
        template.update("INSERT INTO movies (name, movie_year, rating) VALUES (?,?,?)", 
                        name, year, rating);
    }
    
    public List<Movie> findMoviesByName(String nameStartsWith) {
        // Write your code here
        return template.query(
            "select name, movie_year, rating from movies where name like '" 
            + nameStartsWith 
            + "%'", 
                (resultSet, rowNum) -> 
                    new Movie(
                        resultSet.getString("name"), 
                        resultSet.getInt("movie_year"), 
                        resultSet.getInt("rating"))
                    );
        
    }
}
