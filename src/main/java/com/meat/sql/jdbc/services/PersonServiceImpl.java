package com.meat.sql.jdbc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.meat.spring.mvc.model.Person;
import com.meat.sql.jdbc.dao.PersonDAO;

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


	@Override
	public boolean isValidUser(String userName, String passWord) {
		return personDAO.isValid(userName,passWord);
	}

}
