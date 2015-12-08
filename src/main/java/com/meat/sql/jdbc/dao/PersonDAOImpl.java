package com.meat.sql.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.meat.spring.mvc.model.Person;
import com.meat.sql.jdbc.mapper.PersonMapper;
import com.meat.sql.utils.SQLCommand;

public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Person> listAll() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Person> persons = jdbcTemplate.query(SQLCommand.SQL_SELECT_ALL, new PersonMapper());
		return persons;
	}

	@Override
	public void addPerson(Person person) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(SQLCommand.SQL_ADD_PERSON, new Object[] { person.getUserId(), person.getFirstName(),
				person.getLastName(), person.geteMail(), person.getPhone(), person.getStatus(), person.getPassWord(),person.getUserName() });
	}

	@Override
	public boolean isValid(String userName, String passWord) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Person> persons = jdbcTemplate.query(SQLCommand.SQL_SELECT_USERNAME_AND_PASSWORD, new Object[]{userName,passWord},new PersonMapper());
		if(persons.size() > 0) {
			return true;
		}
		return false;
	}

}
