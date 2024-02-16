package com.testdome.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.testdome.java.spring.config.ApplicationConfig;
import com.testdome.java.spring.service.impl.PersonServiceImpl;

public class Application {
	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		PersonServiceImpl personService = applicationContext.getBean(PersonServiceImpl.class);
		System.out.println(personService.getAll());
	}

}
