package com.meat.sql.jdbc.dao;

import java.util.List;

import com.technia.mvc.model.Person;

public interface PersonDAO {

	public List<Person> listAll();
	
	public void addPerson(Person person);
}
