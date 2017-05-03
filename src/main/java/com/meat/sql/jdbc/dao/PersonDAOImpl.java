package com.meat.sql.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.meat.spring.mvc.model.Person;
import com.meat.sql.jdbc.mapper.PersonMapper;
import com.meat.sql.utils.SQLCommand;
import com.meat.sql.utils.SQLLogger;

public class PersonDAOImpl implements PersonDAO {

	private static final Logger logger = Logger.getLogger(PersonDAOImpl.class);
	
	@Autowired
	private DataSource dataSource;

	@Override
	public List<Person> listAll() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		if(logger.isDebugEnabled()) {
			logger.debug("SQL Statement: " + SQLCommand.SQL_SELECT_ALL);
		}
		List<Person> persons = jdbcTemplate.query(SQLCommand.SQL_SELECT_ALL, new PersonMapper());
		return persons;
	}

	@Override
	public void addPerson(Person person) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		if(logger.isDebugEnabled()) {
			logger.debug("SQL Statement: " + SQLLogger.getSQLLog(SQLCommand.SQL_ADD_PERSON, new String[]{person.getUserId(), person.getFirstName(),
					person.getLastName(), person.geteMail(), person.getPhone(), person.getStatus(), person.getPassWord(),person.getUserName()}));
		}
		jdbcTemplate.update(SQLCommand.SQL_ADD_PERSON, new Object[] { person.getUserId(), person.getFirstName(),
				person.getLastName(), person.geteMail(), person.getPhone(), person.getStatus(), person.getPassWord(),person.getUserName() });
	}

	@Override
	public boolean isValid(String userName, String passWord) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		if(logger.isDebugEnabled()) {
			logger.debug("SQL Statement: " + SQLLogger.getSQLLog(SQLCommand.SQL_SELECT_USERNAME_AND_PASSWORD, new String[]{userName,passWord}));
		}
		List<Person> persons = jdbcTemplate.query(SQLCommand.SQL_SELECT_USERNAME_AND_PASSWORD, new Object[]{userName,passWord},new PersonMapper());
		if(persons.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Person> getPersonByUserName(String userName) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		if(logger.isDebugEnabled()) {
			logger.debug("SQL Statement: " + SQLLogger.getSQLLog(SQLCommand.SQL_SELECT_USERNAME, new String[]{userName}));
		}

		return jdbcTemplate.query(SQLCommand.SQL_SELECT_USERNAME, new Object[]{userName},new PersonMapper());
	}

}
