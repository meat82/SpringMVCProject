package com.meat.sql.jdbc.services;

import java.util.List;

import com.technia.mvc.model.Person;

public interface PersonService {

	public List<Person> getPersons();
	
	public void addPerson(Person person);
}
