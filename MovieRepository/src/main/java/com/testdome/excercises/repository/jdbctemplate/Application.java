package com.testdome.excercises.repository.jdbctemplate;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.testdome.excercises.repository.jdbctemplate.bean.Movie;
import com.testdome.excercises.repository.jdbctemplate.config.Config;
import com.testdome.excercises.repository.jdbctemplate.repository.MovieRepository;


public class Application {

	/*
	 * 
	 * mvn clean compile exec:java
	 * 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Config.class);
		context.refresh();
		MovieRepository repository = context.getBean(MovieRepository.class);
		repository.createTable();
		repository.createMovie("Scary movie", 2004, 5);
		repository.createMovie("Scary movie 2", 2005, 6);
		repository.createMovie("Terminator", 2005, 6);
		List<Movie> result = repository.findMoviesByName("Scary");
		result.stream().forEach(movie -> {System.out.println(movie.name);});
	}

}
