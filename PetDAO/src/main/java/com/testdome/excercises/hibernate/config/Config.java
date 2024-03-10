package com.testdome.excercises.hibernate.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.testdome.excercises.hibernate.dao.bean.Pet;
import com.testdome.excercises.hibernate.dao.PetDAO;

@Configuration
@Import({Pet.class, PetDAO.class})
public class Config {

	@Bean
	public SessionFactory getSessionFactory() {
		Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", "jdbc:h2:mem:db1");
        prop.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        prop.setProperty("hibernate.hbm2ddl.auto", "create");
        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().addProperties(prop)
                .addAnnotatedClass(Pet.class).buildSessionFactory();
        return sessionFactory;
	}
}
