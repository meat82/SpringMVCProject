package com.meat.sql.jdbc.dao;

import java.util.List;

import com.meat.spring.mvc.model.Person;

public interface PersonDAO {

	public List<Person> listAll();
	
	public void addPerson(Person person);

	public boolean isValid(String userName, String passWord);

	public List<Person> getPersonByUserName(String userName);

    public Person getPerson(String userId);
}
