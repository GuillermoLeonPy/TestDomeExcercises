package com.testdome.java.spring.crud.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

	public List<T> getAll();
	public T create(T t);
	public Optional<T> getById(Integer id);
	public void update(T t);
	public void delete(Integer id);
}
