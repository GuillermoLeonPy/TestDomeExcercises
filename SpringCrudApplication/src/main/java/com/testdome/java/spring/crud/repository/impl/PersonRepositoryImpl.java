package com.testdome.java.spring.crud.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.testdome.java.spring.crud.model.Person;
import com.testdome.java.spring.crud.repository.CrudRepository;

@Repository
public class PersonRepositoryImpl implements CrudRepository<Person> {

	private List<Person> list;
	
	public PersonRepositoryImpl() {
		super();
		// TODO Auto-generated constructor stub
		list = new ArrayList<>();
		list.add(new Person(1, "Jhonn"));
		list.add(new Person(2, "Peter"));
	}

	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		return list;
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
