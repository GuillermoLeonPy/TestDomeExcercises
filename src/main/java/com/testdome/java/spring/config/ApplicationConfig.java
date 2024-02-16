package com.testdome.java.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.testdome.java.spring.repository.impl.PersonRepositoryImpl;
import com.testdome.java.spring.service.impl.PersonServiceImpl;

@Configuration
@ComponentScan("com.testdome.java.spring")
public class ApplicationConfig {

	/*
	
	@Bean(name = "personService")
	public PersonServiceImpl getPersonService() {
		return new PersonServiceImpl();
	}
	
	@Bean(name = "personRepository")
	public PersonRepositoryImpl getPersonRepository() {
		return new PersonRepositoryImpl();
	}
	*/
}
