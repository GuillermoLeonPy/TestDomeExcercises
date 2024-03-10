package com.testdome.excercises.hibernate.dao.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Pet")
@Table
public class Pet {

    @Id
    public Integer id;
    @Column
    public String name;
    @Column
    public String species;
    
    public Pet() {}
    
    public Pet(Integer id, String name, String species) {
        this.id = id;
        this.name = name;
        this.species = species;
    }
}
