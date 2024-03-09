package com.testdome.excercises.repository.jdbctemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.testdome.excercises.repository.jdbctemplate.repository.MovieRepository;

@Import(MovieRepository.class)
@Configuration
public class Config {

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DriverManagerDataSource ds) {
		return new JdbcTemplate(ds);
	}
}
