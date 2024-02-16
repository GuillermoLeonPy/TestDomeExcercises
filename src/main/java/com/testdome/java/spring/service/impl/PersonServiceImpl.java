package com.testdome.java.spring.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.testdome.java.spring.model.Person;
import com.testdome.java.spring.repository.impl.PersonRepositoryImpl;
import com.testdome.java.spring.service.CrudService;

@Service
public class PersonServiceImpl implements CrudService<Person> {	
	
	private PersonRepositoryImpl personRepository;
	
	public PersonServiceImpl(PersonRepositoryImpl personRepository) {
		super();
		this.personRepository = personRepository;
	}

	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		return personRepository.getAll();
	}

	@Override
	public Person create(Person t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Person> getById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Person t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
