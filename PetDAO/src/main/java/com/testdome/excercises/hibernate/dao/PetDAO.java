package com.testdome.excercises.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.testdome.excercises.hibernate.dao.bean.Pet;

@Component
public class PetDAO {
	public List<Pet> findNamedPetsBySpecies(Session session, String species) {
        Query<Pet> query = session.createQuery("select p from Pet p where p.name is not null and p.species = :pspecies", Pet.class);
        query.setParameter("pspecies", species);
        return query.list();
    }

}
