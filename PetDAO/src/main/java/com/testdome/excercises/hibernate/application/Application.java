package com.testdome.excercises.hibernate.application;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.testdome.excercises.hibernate.config.Config;
import com.testdome.excercises.hibernate.dao.PetDAO;
import com.testdome.excercises.hibernate.dao.bean.Pet;

/*
 * 
 * mvn clean compile exec:java
 * 
 * */

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Config.class);
		context.refresh();
		
		SessionFactory sf = context.getBean(SessionFactory.class);
		Session session = sf.openSession();
		session.beginTransaction();
        
        Pet dog = new Pet(0, "Lady", "Dog");
        Pet cat = new Pet(1, "Max", "Cat");
        Pet camel = new Pet(2, null, "Camel");
        
        session.save(dog);
        session.save(cat);
        session.save(camel);
        session.flush();
        
        PetDAO dao = context.getBean(PetDAO.class);
        List<Pet> list = dao.findNamedPetsBySpecies(session, "Dog");
        list.stream().forEach(pet -> {System.out.println(pet.name);});
        
        session.close();
        sf.close();
        context.close();
        
	}

}
