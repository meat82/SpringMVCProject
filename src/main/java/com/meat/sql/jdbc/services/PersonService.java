package com.meat.sql.jdbc.services;

import java.util.List;

import com.meat.spring.mvc.model.Person;

public interface PersonService {

	public List<Person> getPersons();
	
	public void addPerson(Person person);

	public boolean isValidUser(String userName, String passWord);

	public List<Person> getPersonByUserName(String userName);

    public Person getPerson(String userId);
}
