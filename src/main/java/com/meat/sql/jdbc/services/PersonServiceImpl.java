package com.meat.sql.jdbc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.meat.sql.jdbc.dao.PersonDAO;
import com.technia.mvc.model.Person;

public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDAO personDAO;
	
	
	@Override
	public List<Person> getPersons() {
		return personDAO.listAll();
	}


	@Override
	public void addPerson(Person person) {
		personDAO.addPerson(person);
	}

}
